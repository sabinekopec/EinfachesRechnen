package exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveFileDialog extends JFrame {


	public SaveFileDialog() {
		
		showSaveFileDialog();
	}

	private void showSaveFileDialog() {
		
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Aufgaben sichern unter:");

		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			
			ArrayList<String> listOfExercises = (ArrayList<String>) GenerateListOfExercises.getListOfExercises();
			
			
			File fileToSave = new File(fileChooser.getSelectedFile()+".txt");
			
			try {
			    Files.write(Paths.get(fileToSave.getAbsolutePath()), listOfExercises);
			} catch (IOException e) {
			    System.out.println("Unable to write out exercises");
			}
			
		}
	}
}
