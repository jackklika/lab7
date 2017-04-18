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

	public Racer e;

	public GUI() {

		createContents();

	}

	private void createContents() {

		String[] items = { "Mr.", "Ms.", "Mrs.", "Dr.", "Col.", "Prof" };
		JComboBox combo = new JComboBox(items);

		JTextField firstInitial = new JTextField("");
		JTextField lastName = new JTextField("");
		JTextField BibNumber = new JTextField("");
		JTextField Time = new JTextField("");

		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("First Initial: "));
		panel.add(firstInitial);
		panel.add(new JLabel("Last Name:"));
		panel.add(lastName);
		panel.add(new JLabel("Bib Number:"));
		panel.add(BibNumber);
		panel.add(new JLabel("Time:"));
		panel.add(Time);

		int result = JOptionPane.showConfirmDialog(null, panel, "Lab 8",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			// TODO Create the appropriate object
			// e = new Employee(combo.getSelectedItem().toString(),
			// firstInitial.getText(), lastName.getText(), BibNumber.getText(),
			// Time.getText(),
			// "Other");
			// System.out.println(e);

		} else {
			System.out.println("Cancelled");
		}
	}
}
