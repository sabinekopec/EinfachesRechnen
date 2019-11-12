/*
 *  @version 1.08    November 2019
 *  
 *  @author Sabine Kopec
 *  
 *  This program is free software.
 *  
 */


package exercises;
import java.awt.GridBagLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.List;



public class StartFrame extends JFrame {

	private JPanel contentPane;
	private String difficulty;
	private String exerciseType;
	private static int minNumber, maxNumber;

	private static List<String> arithmeticOperations = new ArrayList<String>();
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public static List<String> getArithmeticOperations() {
		return arithmeticOperations;
	}
	
	public static int[] getNumberRange() {
		int[] list = {minNumber,maxNumber};
		return list;
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setTitle("Schwierigkeitsstufe wählen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{29, 29, 29, 0, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);
		
		JLabel lblZahlenraum = new JLabel("Zahlenraum auswählen");
		GridBagConstraints gbc_lblZahlenraum = new GridBagConstraints();
		gbc_lblZahlenraum.anchor = GridBagConstraints.WEST;
		gbc_lblZahlenraum.insets = new Insets(0, 0, 5, 5);
		gbc_lblZahlenraum.gridx = 0;
		gbc_lblZahlenraum.gridy = 0;
		contentPane.add(lblZahlenraum, gbc_lblZahlenraum);
		
		JComboBox cbNumberSpace = new JComboBox();
		cbNumberSpace.setModel(new DefaultComboBoxModel(new String[] {"Zahlen bis 5", "Zahlen bis 10", "Zahlen bis 15", "Zahlen bis 20", "Zahlen von 100-200"}));
		cbNumberSpace.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String numberSpace = (String) cb.getSelectedItem();
				
				switch(numberSpace) {
				case "Zahlen bis 5":
					minNumber = 0;
					maxNumber= 5;
					break;
				case "Zahlen bis 10":
					minNumber = 0;
					maxNumber= 10;
					break;
				case "Zahlen bis 15":
					minNumber = 0;
					maxNumber= 15;
					break;
				case "Zahlen bis 20":
					minNumber = 0;
					maxNumber= 20;
					break;
				case "Zahlen von 100-200":
					minNumber = 100;
					maxNumber = 200;
				}
			}
		});
		
		GridBagConstraints gbc_cbNumberSpace = new GridBagConstraints();
		gbc_cbNumberSpace.anchor = GridBagConstraints.WEST;
		gbc_cbNumberSpace.insets = new Insets(0, 0, 5, 0);
		gbc_cbNumberSpace.gridx = 2;
		gbc_cbNumberSpace.gridy = 0;
		contentPane.add(cbNumberSpace, gbc_cbNumberSpace);
		
		cbNumberSpace.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				difficulty = (String) cb.getSelectedItem();
			}
		});
		
		JLabel lblExerciseType = new JLabel("Aufgabentyp auswählen");
		GridBagConstraints gbc_lblExerciseType = new GridBagConstraints();
		gbc_lblExerciseType.anchor = GridBagConstraints.WEST;
		gbc_lblExerciseType.insets = new Insets(0, 0, 5, 5);
		gbc_lblExerciseType.gridx = 0;
		gbc_lblExerciseType.gridy = 1;
		contentPane.add(lblExerciseType, gbc_lblExerciseType);
		
		JComboBox cbExerciseType = new JComboBox();
		cbExerciseType.setModel(new DefaultComboBoxModel(new String[] {"manuell eintragen", "10 Aufgaben zum Drucken"}));
		GridBagConstraints gbc_cbExerciseType = new GridBagConstraints();
		gbc_cbExerciseType.anchor = GridBagConstraints.WEST;
		gbc_cbExerciseType.insets = new Insets(0, 0, 5, 0);
		gbc_cbExerciseType.gridx = 2;
		gbc_cbExerciseType.gridy = 1;
		contentPane.add(cbExerciseType, gbc_cbExerciseType);
		
		cbExerciseType.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				exerciseType = (String) cb.getSelectedItem();
			}
		});
		
		JLabel lblOperationen = new JLabel("Rechenoperationen");
		GridBagConstraints gbc_lblOperationen = new GridBagConstraints();
		gbc_lblOperationen.anchor = GridBagConstraints.WEST;
		gbc_lblOperationen.insets = new Insets(0, 0, 5, 5);
		gbc_lblOperationen.gridx = 0;
		gbc_lblOperationen.gridy = 3;
		contentPane.add(lblOperationen, gbc_lblOperationen);
		
		JRadioButton rdbtnAddition = new JRadioButton("Addition");
		GridBagConstraints gbc_rdbtnAddition = new GridBagConstraints();
		gbc_rdbtnAddition.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAddition.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnAddition.gridx = 2;
		gbc_rdbtnAddition.gridy = 3;
		contentPane.add(rdbtnAddition, gbc_rdbtnAddition);
		
		rdbtnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAddition.isSelected()){ 
					arithmeticOperations.add("+");
				}
			}
		});
		
		JRadioButton rdbtnSubtraction = new JRadioButton("Subtraktion");
		GridBagConstraints gbc_rdbtnSubtraction = new GridBagConstraints();
		gbc_rdbtnSubtraction.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSubtraction.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnSubtraction.gridx = 2;
		gbc_rdbtnSubtraction.gridy = 4;
		contentPane.add(rdbtnSubtraction, gbc_rdbtnSubtraction);
		
		rdbtnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSubtraction.isSelected()){ 
					arithmeticOperations.add("-");
				}
			}
		});
		
		JRadioButton rdbtnMultiplication = new JRadioButton("Multiplikation");
		GridBagConstraints gbc_rdbtnMultiplication = new GridBagConstraints();
		gbc_rdbtnMultiplication.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMultiplication.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMultiplication.gridx = 2;
		gbc_rdbtnMultiplication.gridy = 5;
		contentPane.add(rdbtnMultiplication, gbc_rdbtnMultiplication);
		
		rdbtnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMultiplication.isSelected()){ 
					arithmeticOperations.add("*");
				}
			}
		});
		
		JRadioButton rdbtnDivision = new JRadioButton("Division");
		GridBagConstraints gbc_rdbtnDivision = new GridBagConstraints();
		gbc_rdbtnDivision.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnDivision.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDivision.gridx = 2;
		gbc_rdbtnDivision.gridy = 6;
		contentPane.add(rdbtnDivision, gbc_rdbtnDivision);
		
		rdbtnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDivision.isSelected()){ 
					arithmeticOperations.add("/");
				}
			}
		});
		
		Button buttonConfirm = new Button("Auswahl bestätigen");
		
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExerciseFrame();
			}
		});
		
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.insets = new Insets(0, 0, 5, 5);
		gbc_confirm.gridx = 1;
		gbc_confirm.gridy = 8;
		contentPane.add(buttonConfirm, gbc_confirm);
		
//		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public static void main(String[] args) {
//		
//		new StartFrame();
////		frame.getArithmeticOperations();
//	}

	
}
