package exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaveFileDialog extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8908695787179211568L;
	private ArrayList<String> listOfExercises;
	
	
	public SaveFileDialog(ArrayList<String> listOfExercises) {
		
		this.listOfExercises = listOfExercises;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Aufgaben sichern unter:");

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			
			
			File fileToSave = new File(fileChooser.getSelectedFile()+".txt");
			
			try {
			    Files.write(Paths.get(fileToSave.getAbsolutePath()), listOfExercises);
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(null, "Datei konnte nicht geschrieben werden.", "Fehler", JOptionPane.PLAIN_MESSAGE);
				
//			    System.out.println("Unable to write out exercises");
			}
			
		}
		
	}
}
