package exercises;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class HandlingExercises extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public HandlingExercises() {
		setTitle("");
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblTextInfo = new JLabel("<html><body style='width: 8cm;text-align:center'>Sollen die Aufgaben gespeichert oder gedruckt werden?</body></html>");
			contentPanel.add(lblTextInfo);
			lblTextInfo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.CENTER);
			{
				JButton btnSaveAsFile = new JButton("Speichern als");
				btnSaveAsFile.setVerticalAlignment(SwingConstants.BOTTOM);
				btnSaveAsFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new SaveFileDialog();
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
						new PrintFileDialog();	    
					}
				});
				
				buttonPane.add(btnPrint);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.SOUTH);
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
