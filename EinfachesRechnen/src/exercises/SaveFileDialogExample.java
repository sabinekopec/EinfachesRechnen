package exercises;
/**
 * @(#)SaveFileDialogExample.java 1.0
 * This code is written by www.codejava.net
 *
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SaveFileDialogExample extends JFrame {


	public SaveFileDialogExample() {
		
		showSaveFileDialog();
//		init();
//		super("Save File Dialog Example");
//		setLayout(new FlowLayout());
//		buttonBrowse = new JButton("Save...");
//		buttonBrowse.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				showSaveFileDialog();
//			}
//		});
//		getContentPane().add(buttonBrowse);
//		setSize(300, 100);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
	}

//	public void init() {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) { }
//
//        SwingUtilities.invokeLater(new Runnable() {
//
//			public void run() {
//				new SaveFileDialogExample();
//			}
//		});
//	}

	private void showSaveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Aufgaben sichern unter:");
//		fileChooser.setApproveButtonText("Sichern");

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			
			ArrayList<String> listOfExercises = (ArrayList<String>) GenerateListOfExercises.getListOfExercises();
			
			
			File fileToSave = new File(fileChooser.getSelectedFile()+".txt");
			
			try {
			    Files.write(Paths.get(fileToSave.getAbsolutePath()), listOfExercises);
			} catch (IOException e) {
			    System.out.println("Unable to write out names");
			}
			
//			try(FileWriter fw = new FileWriter(fileToSave)) {
//				for (String exercise: listOfExercises) {
//					fw.write(exercise);
//				}
//			}
////			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//			catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}
}
