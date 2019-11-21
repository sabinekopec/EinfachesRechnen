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
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;



public class StartFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7065162247067825117L;
	/**
	 * 
	 */
	private JPanel contentPane;
//	private String difficulty;
	private String numberOfExercises;
	private static int minNumber, maxNumber;
	
	private static boolean useFraction;

	private static List<String> arithmeticOperations = new ArrayList<String>();
	
//	public String getDifficulty() {
//		return difficulty;
//	}
	
	public static List<String> getArithmeticOperations() {
		return arithmeticOperations;
	}
	
	public static int[] getNumberRange() {
		int[] list = {minNumber,maxNumber};
		return list;
	}
	
	public static boolean getUseFraction() {
		return useFraction;
	}

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setTitle("Schwierigkeitsstufe wählen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{29, 29, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		JComboBox<Object> cbNumberSpace = new JComboBox<Object>();
		cbNumberSpace.setModel(new DefaultComboBoxModel<Object>(new String[] {"" , "Zahlen bis 5", "Zahlen bis 10", "Zahlen bis 15", "Zahlen bis 20", "Zahlen von 100-200"}));
		cbNumberSpace.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
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
		
//		cbNumberSpace.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				JComboBox<String> cb = (JComboBox<String>) e.getSource();
//				difficulty = (String) cb.getSelectedItem();
//			}
//		});
		
		JLabel lblNumberOfExercises = new JLabel("Aufgabentyp auswählen");
		GridBagConstraints gbc_lblNumberOfExercises = new GridBagConstraints();
		gbc_lblNumberOfExercises.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfExercises.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfExercises.gridx = 0;
		gbc_lblNumberOfExercises.gridy = 1;
		contentPane.add(lblNumberOfExercises, gbc_lblNumberOfExercises);
		
		JComboBox<String> cbNumberOfExercises = new JComboBox<String>();
		cbNumberOfExercises.setModel(new DefaultComboBoxModel<String>(new String[] {"manuell eintragen", "10 Aufgaben zum Drucken"}));
		GridBagConstraints gbc_cbNumberOfExercises = new GridBagConstraints();
		gbc_cbNumberOfExercises.anchor = GridBagConstraints.WEST;
		gbc_cbNumberOfExercises.insets = new Insets(0, 0, 5, 0);
		gbc_cbNumberOfExercises.gridx = 2;
		gbc_cbNumberOfExercises.gridy = 1;
		contentPane.add(cbNumberOfExercises, gbc_cbNumberOfExercises);
		
		cbNumberOfExercises.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				numberOfExercises = (String) cb.getSelectedItem();
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
				if (arithmeticOperations.size()!=0 && arithmeticOperations.contains("+")) {
					arithmeticOperations.remove("+");
				}
				
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
				if (arithmeticOperations.size()!=0 && arithmeticOperations.contains("-")) {
					arithmeticOperations.remove("-");
				}
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
				if (arithmeticOperations.size()!=0 &&  arithmeticOperations.contains("*")) {
					arithmeticOperations.remove("*");
				}
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
				if (arithmeticOperations.size()!=0 && arithmeticOperations.contains("/")) {
					arithmeticOperations.remove("/");
				}
				
				if(rdbtnDivision.isSelected()){ 
					arithmeticOperations.add("/");
				}
			}
		});
		
		
		JLabel lblUseFraction = new JLabel("Rationale Zahlen üben?");
		GridBagConstraints gbc_lblUseFraction = new GridBagConstraints();
		gbc_lblUseFraction.insets = new Insets(0, 0, 5, 5);
		gbc_lblUseFraction.gridx = 0;
		gbc_lblUseFraction.gridy = 8;
		contentPane.add(lblUseFraction, gbc_lblUseFraction);
		
		JComboBox<Object> cbUseFraction = new JComboBox<Object>();
		cbUseFraction.setModel(new DefaultComboBoxModel<Object>(new String[] {"" , "ja", "nein"}));
		cbUseFraction.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String selectionUseFraction = (String) cb.getSelectedItem();
				
				switch(selectionUseFraction) {
				case "ja":
					useFraction = true;
					break;
				case "nein":
					useFraction = false;
					break;
				default:
					useFraction = false;
				}
			}
		});
		
		GridBagConstraints gbc_cbUseFraction = new GridBagConstraints();
		gbc_cbUseFraction.anchor = GridBagConstraints.WEST;
		gbc_cbUseFraction.insets = new Insets(0, 0, 5, 0);
		gbc_cbUseFraction.gridx = 2;
		gbc_cbUseFraction.gridy = 8;
		contentPane.add(cbUseFraction, gbc_cbUseFraction);
		
		
		Button buttonConfirm = new Button("Auswahl bestätigen");
		
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (arithmeticOperations.isEmpty()) {
					JOptionPane.showConfirmDialog(null, "Keine Rechenoperation ausgewählt. Welche Rechenoperationen möchtest du üben?", "Fehlende Rechenoperation", JOptionPane.PLAIN_MESSAGE);
				} else if (maxNumber==0) {
					JOptionPane.showConfirmDialog(null, "Kein Zahlenraum ausgewählt. In welchem Zahlenraum möchtest du üben?", "Fehlender Zahlenraum", JOptionPane.PLAIN_MESSAGE);
				} else {
					
					if (numberOfExercises != null && numberOfExercises.equals("10 Aufgaben zum Drucken")) {
						new GenerateListOfExercises();
					} else {
						new ExerciseFrame();
					}
				}
			}
		});
		
		
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_confirm.gridx = 1;
		gbc_confirm.gridy = 11;
		contentPane.add(buttonConfirm, gbc_confirm);
		
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



	
}
