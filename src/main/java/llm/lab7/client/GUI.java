package llm.lab7.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import llm.lab7.Racer;

public class GUI extends JFrame {

	public Racer r;

	public GUI() {

		createContents();

	}

	private void createContents() {

	
		JTextField firstInitial = new JTextField("");
		JTextField lastName = new JTextField("");
		JTextField bibNumber = new JTextField("");
		JTextField time = new JTextField("");

		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("First Initial: "));
		panel.add(firstInitial);
		panel.add(new JLabel("Last Name:"));
		panel.add(lastName);
		panel.add(new JLabel("Bib Number:"));
		panel.add(bibNumber);
		panel.add(new JLabel("Time:"));
		panel.add(time);

		int result = JOptionPane.showConfirmDialog(null, panel, "Lab 12",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
		String initial = firstInitial.getText().substring(0, 1);
			// TODO Create the appropriate object
			r = new Racer(bibNumber.getText(), lastName.getText(),
					initial, time.getText());
			System.out.println(r);

		} else {
			System.out.println("Cancelled");
		}
	}
}
