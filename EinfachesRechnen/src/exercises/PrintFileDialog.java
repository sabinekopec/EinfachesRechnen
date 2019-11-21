package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

public class PrintFileDialog {

	File temp;
	private ArrayList<String> arrayToPrint;
	boolean print = false;

	public PrintFileDialog(ArrayList<String> arrayToPrint) {
		
		this.arrayToPrint = arrayToPrint;
		
		createTemporaryFile();
		showPrintFileDialog();
	}

	
	/*
	 * show dialog to select printer and print temporary file if printerselection was succesful
	 */
	private void showPrintFileDialog() {
		
		
		
		
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
		PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
		PrintService selectedPrintService = ServiceUI.printDialog(null, 150, 150, printServices, defaultPrintService, null, attrib);
	
		if(selectedPrintService!=null) {
			System.out.println("selected printer:"+selectedPrintService.getName());
		
		
			DocPrintJob job = selectedPrintService.createPrintJob();
			job.addPrintJobListener(new PrintJobAdapter() {
				public void printDataTransferCompleted(PrintJobEvent event){
					System.out.println("data transfer complete");
				}
				public void printJobNoMoreEvents(PrintJobEvent event){
					System.out.println("received no more events");
				}
			});
			
			printTempFile(attrib, job);
			
		} else {	   
			System.out.println("selection cancelled");
		}
			
	}


	/*
	 * print temporary file
	 */
	
	private void printTempFile(PrintRequestAttributeSet attrib, DocPrintJob job) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(temp);
			Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
			attrib.add(new Copies(1));
			job.print(doc, attrib);
		} catch (FileNotFoundException e) {
			JOptionPane.showConfirmDialog(null, "<html><body style='width: 8cm;text-align:center'>Es konnte keine temporäre Datei angelegt werden. Bitte wähle die Option Speichern als.<body><html>", "Fehler", JOptionPane.PLAIN_MESSAGE);
			e.printStackTrace();
		} catch (PrintException e) {
			JOptionPane.showConfirmDialog(null, "Druckauftrag konnte nicht ausgeführt werden.", "Fehler", JOptionPane.PLAIN_MESSAGE);
			e.printStackTrace();
		}
	}

	
/* 
 * create a temporary file of the exercises 
 * path is afterwards used in method showPrintFileDialog 
 */	
	private void createTemporaryFile() {
//		ArrayList<String> listOfExercises = (ArrayList<String>) GenerateListOfExercises.getListOfExercises();
		
		try {
			temp = File.createTempFile("tempFile", ".tmp"); 
		    Files.write(Paths.get(temp.getAbsolutePath()), arrayToPrint);
		    
		    System.out.println("Temp file : " + temp.getAbsolutePath());
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "<html><body style='width: 8cm;text-align:center'>Es konnte keine temporäre Datei angelegt werden. Bitte wähle die Option Speichern als.<body><html>", "Fehler", JOptionPane.PLAIN_MESSAGE);
//		    System.out.println("Unable to write out exercises");
		}
	}
}
