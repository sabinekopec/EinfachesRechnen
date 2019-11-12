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
	
	
	public ExerciseFrame() {
		
		callExercise();
		
		
		// general setup
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		contentPane.add(panelEquation);
		
		int exerciseType = exercise.getExerciseType();
		
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
					if (txtNumber.getText().equals(Integer.toString(exercise.getNumber2()))) {
						statusMessage.setText("Das ist richtig, gut gemacht!");
						correct = true;
					}
					break;
				case 2:
					if (txtNumber.getText().equals(Integer.toString(exercise.getNumber1()))) {
						statusMessage.setText("Das ist richtig, gut gemacht!");
						correct = true;
					}
					break;
				case 3:
					if (txtNumber.getText().equals(Integer.toString(exercise.getResult()))) {
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
					txtNumber.setText(Integer.toString(exercise.getNumber2()));
					break;
				case 2:
					txtNumber.setText(Integer.toString(exercise.getNumber1()));
					break;
				case 3:
					txtNumber.setText(Integer.toString(exercise.getResult()));
				}
				
				
			}
		});
		
				
		contentPane.add(panelNextTask);
				
				
		JButton btnNext = new JButton("Nächste Aufgabe");
		panelNextTask.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callExercise();
			}
		});
	
		

		setVisible(true);
	}
	
	private void callExercise() {
		exercise = new Exercise();
		exercise.init();

		lblNumber1.setText(Integer.toString(exercise.getNumber1()));
		lblNumber2.setText(Integer.toString(exercise.getNumber2()));
		lblOperation.setText(exercise.getOperation());
		
		lblResult.setText(Integer.toString(exercise.getResult()));
		statusMessage.setText("Bitte die Lösung in das Textfeld eintragen.");
		txtNumber.setText("");
		
		
		
	}
	
}
