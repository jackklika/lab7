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

import llm.lab7.Employee;

public class GUI extends JFrame {

	private JLabel firstName;
	private JLabel lastName;
	private JLabel dept;
	private JLabel phone;
	private JLabel gender;
	private JLabel title;

	public GUI() {
		// setTitle("Lab 8");
		// setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setVisible(true);
		// setSize(600,600);
		createContents();

	}

	private void createContents() {

		String[] items = { "Mr.", "Ms.", "Mrs.", "Dr.", "Col.", "Prof" };
		JComboBox combo = new JComboBox(items);

		JTextField firstName = new JTextField("");
		JTextField lastName = new JTextField("");
		JTextField department = new JTextField("");
		JTextField phone = new JTextField("");

		JRadioButton male = new JRadioButton("Male");
		male.setSelected(true);
		JRadioButton female = new JRadioButton("Female");
		JRadioButton other = new JRadioButton("Other");
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);
		group.add(other);

		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("First Name: "));
		panel.add(firstName);
		panel.add(new JLabel("Last Name:"));
		panel.add(lastName);
		panel.add(new JLabel("Department:"));
		panel.add(department);
		panel.add(new JLabel("Phone Number:"));
		panel.add(phone);
		panel.add(new JLabel("Gender:"));
		panel.add(male);
		panel.add(female);
		panel.add(other);
		panel.add(new JLabel("Title: "));
		panel.add(combo);

		int result = JOptionPane.showConfirmDialog(null, panel, "Lab 8", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (male.isSelected()) {
				Employee e1 = new Employee(firstName.getText(), lastName.getText(), department.getText(),
						phone.getText(), combo.getSelectedItem().toString(), "Male");
				System.out.println(e1);
			} else if (female.isSelected()) {
				Employee e1 = new Employee(firstName.getText(), lastName.getText(), department.getText(),
						phone.getText(), combo.getSelectedItem().toString(), "Female");
				System.out.println(e1);
			} else {
				Employee e1 = new Employee(firstName.getText(), lastName.getText(), department.getText(),
						phone.getText(), combo.getSelectedItem().toString(), "Other");
				System.out.println(e1);
			}

		} else {
			System.out.println("Cancelled");
		}
	}

}
