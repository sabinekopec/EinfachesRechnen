package exercises;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class HandlingExercises extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6015619333972297300L;
	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("unused")
	private List<String> listOfExercises;

	/**
	 * Create the dialog.
	 * @param  
	 * @param listOfExercises 
	 */
	public HandlingExercises(ArrayList<String> listOfExercises) {
		
		this.listOfExercises = listOfExercises;
		setTitle("");
//		setSize(new Dimension(100, 300));
//		setPreferredSize(new Dimension(100, 300));
		setBounds(100, 300, 300, 385);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{292, 0};
		gridBagLayout.rowHeights = new int[] {41, 41, 41, 41, 0, 0, 0, 30};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		
		{
			JLabel lblTextInfo = new JLabel("<html><body style='width: 8cm;text-align:center'>Sollen die Aufgaben gespeichert oder gedruckt werden?</body></html>");
			contentPanel.add(lblTextInfo);
			lblTextInfo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		{
			JPanel exercisePane = new JPanel();
			exercisePane.setLayout(new FlowLayout(FlowLayout.CENTER));
			GridBagConstraints gbc_exercisePane = new GridBagConstraints();
			gbc_exercisePane.gridheight = 4;
			gbc_exercisePane.fill = GridBagConstraints.BOTH;
			gbc_exercisePane.insets = new Insets(0, 0, 5, 0);
			gbc_exercisePane.gridx = 0;
			gbc_exercisePane.gridy = 1;
			getContentPane().add(exercisePane, gbc_exercisePane);
			{
				JList<Object> exercisesList = new JList<Object>(listOfExercises.toArray());
				exercisesList.setVisibleRowCount(10);
				exercisePane.add(exercisesList);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.fill = GridBagConstraints.BOTH;
			gbc_buttonPane.insets = new Insets(0, 0, 5, 0);
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 5;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton btnSaveAsFile = new JButton("Speichern als");
				btnSaveAsFile.setVerticalAlignment(SwingConstants.BOTTOM);
				btnSaveAsFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new SaveFileDialog(listOfExercises);
					}
				});
				buttonPane.add(btnSaveAsFile);
				getRootPane().setDefaultButton(btnSaveAsFile);
			}
			{
				JButton btnPrint = new JButton("Drucken");
				btnPrint.setVerticalAlignment(SwingConstants.BOTTOM);
				
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new PrintFileDialog(listOfExercises);	    
					}
				});
				
				buttonPane.add(btnPrint);
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 6;
			getContentPane().add(panel, gbc_panel);
			{
				JButton btnCloseWindow = new JButton("Fenster schließen");
				btnCloseWindow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				panel.add(btnCloseWindow);
			}
		}

		setVisible(true);
	}

}
