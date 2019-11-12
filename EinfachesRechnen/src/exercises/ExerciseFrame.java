package exercises;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ExerciseFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNumber = new JTextField();
	private JLabel statusMessage = new JLabel();
	
//	private int number1, number2, result;
//	private String operation;
	
	private JLabel lblNumber = new JLabel();
	private JLabel lblResult = new JLabel(); 
	private JLabel lblOperation = new JLabel();
	
	Exercise exercise;
	
	public ExerciseFrame() {
		
		callExercise();
		
		
		// general setup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		// different positions of missing number
		
		
		
		getContentPane().add(lblNumber);
		
		getContentPane().add(lblOperation);
		
		getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		JLabel lblEquals = new JLabel(" = ");
		getContentPane().add(lblEquals);
		
		
		getContentPane().add(lblResult);
		
		statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(statusMessage, BorderLayout.NORTH);
		
		
		
		JButton btnShowResult = new JButton("Lösung anzeigen");
		contentPane.add(btnShowResult, BorderLayout.SOUTH);
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumber.setText(Integer.toString(exercise.getNumber2()));
				
			}
		});
		
		JButton btnProofResult = new JButton("Lösung prüfen");
		contentPane.add(btnProofResult, BorderLayout.SOUTH);
		btnProofResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNumber.getText().equals(Integer.toString(exercise.getNumber2()))) {
					statusMessage.setText("Gut gemacht!");
				} else {
					statusMessage.setText("Das stimmt nicht, versuch es noch einmal");
				}
			}
		});
		
		
		JButton btnNext = new JButton("Nächste Aufgabe");
//		btnNext.setVerticalAlignment(SwingConstants.CENTER);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callExercise();
			}
		});
		contentPane.add(btnNext, BorderLayout.CENTER);
		
		

		setVisible(true);
	}
	
	private void callExercise() {
		exercise = new Exercise();
		
		lblNumber.setText(Integer.toString(exercise.getNumber1()));
		lblOperation.setText(exercise.getOperation());
		lblResult.setText(Integer.toString(exercise.getResult()));
		statusMessage.setText("Bitte die Lösung in das Textfeld eintragen.");
		txtNumber.setText("");
		
		
		
	}
	
}
