package exercises;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;


public class ExerciseFrame extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1159996402073146002L;
	private final JPanel contentPane = new JPanel();
	private final JPanel panelNextTask = new JPanel();
	private final JPanel panelSolution = new JPanel();
	private final JPanel panelEquation = new JPanel();
	private final JPanel panelStatusMessage = new JPanel();
	
	
	private JTextField txtNumber = new JTextField();
	private JLabel statusMessage = new JLabel();
	
	private JLabel lblNumber1 = new JLabel();
	private JLabel lblNumber2 = new JLabel();
	private JLabel lblResult = new JLabel(); 
	private JLabel lblOperation = new JLabel();
	
	Exercise exercise;
	private int exerciseType;
	
	
	public ExerciseFrame() {
		
		callExercise();
		showExerciseFrame();
	}
	
	private void showExerciseFrame() {
		
		// general setup
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		contentPane.add(panelEquation);
		
		switch(exerciseType) {
		case 1:
			panelEquation.add(lblNumber1);
			panelEquation.add(lblOperation);
			panelEquation.add(txtNumber);
			panelEquation.add(new JLabel(" = "));
			panelEquation.add(lblResult);
			break;
		case 2:
			panelEquation.add(txtNumber);
			panelEquation.add(lblOperation);
			panelEquation.add(lblNumber2);
			panelEquation.add(new JLabel(" = "));
			panelEquation.add(lblResult);
			break;
		case 3:
			panelEquation.add(lblNumber1);
			panelEquation.add(lblOperation);
			panelEquation.add(lblNumber2);
			panelEquation.add(new JLabel(" = "));
			panelEquation.add(txtNumber);
		}
			
		
			
		txtNumber.setColumns(10);
		contentPane.add(panelStatusMessage);
		panelStatusMessage.add(statusMessage);
		
//		statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		contentPane.add(panelSolution);
		

		
		JButton btnProofResult = new JButton("Lösung prüfen");
		panelSolution.add(btnProofResult);
		btnProofResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean correct = false;
				switch(exerciseType) {
				case 1:
					if (txtNumber.getText().equals(exercise.getNumber2().toString())) {
						statusMessage.setText("Das ist richtig, gut gemacht!");
						correct = true;
					}
					break;
				case 2:
					if (txtNumber.getText().equals(exercise.getNumber1().toString())) {
						statusMessage.setText("Das ist richtig, gut gemacht!");
						correct = true;
					}
					break;
				case 3:
					if (txtNumber.getText().equals(exercise.getResult().toString())) {
						statusMessage.setText("Das ist richtig, gut gemacht!");
						correct = true;
					}
				}
				if (!correct) {
					statusMessage.setText("Das stimmt leider nicht, versuch es noch einmal!");
				}
			}
		});

		
		JButton btnShowResult = new JButton("Lösung anzeigen");
		panelSolution.add(btnShowResult);
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(exerciseType) {
				case 1:
					txtNumber.setText(exercise.getNumber2().toString());
					break;
				case 2:
					txtNumber.setText(exercise.getNumber1().toString());
					break;
				case 3:
					txtNumber.setText(exercise.getResult().toString());
				}
				
				
			}
		});
		
				
		contentPane.add(panelNextTask);
				
				
		JButton btnNext = new JButton("Nächste Aufgabe");
		panelNextTask.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ExerciseFrame();
				//callExercise();
				
			}
		});
	
		

		setVisible(true);
	}
	
	private void callExercise() {
		exercise = new Exercise();
		exercise.init();
		
		exerciseType = exercise.getExerciseType();

		lblNumber1.setText(exercise.getNumber1().toString());
		lblNumber2.setText(exercise.getNumber2().toString());
		lblOperation.setText(exercise.getOperation());
		
		lblResult.setText(exercise.getResult().toString());
		statusMessage.setText("Bitte die Lösung in das Textfeld eintragen.");
		txtNumber.setText("");
		
		
		
	}
	
}
