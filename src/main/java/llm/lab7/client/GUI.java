package llm.lab7.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import llm.lab7.Racer;

public class GUI extends JFrame {

	//public Racer r;
	public File racers;
	public ArrayList<Racer> rl = new ArrayList<Racer>();
	
	JTextField firstInitial;
	JTextField lastName;
	JTextField bibNumber;
	JTextField time;

	public GUI() {

		createContents();

	}

	private void createContents() {

		//String[] items = { "Mr.", "Ms.", "Mrs.", "Dr.", "Col.", "Prof" };
		//JComboBox combo = new JComboBox(items);

		JButton openFile = new JButton("Open Racer File");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    selectFile();
			}
		});
		
		firstInitial = new JTextField("");
		lastName = new JTextField("");
		bibNumber = new JTextField("");
		time = new JTextField("");

		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(openFile);
		panel.add(new JLabel("First Initial: "));
		panel.add(firstInitial);
		panel.add(new JLabel("Last Name:"));
		panel.add(lastName);
		panel.add(new JLabel("Bib Number:"));
		panel.add(bibNumber);
		panel.add(new JLabel("Time:"));
		panel.add(time);

		int result = JOptionPane.showConfirmDialog(
				null, panel, "Lab 8",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			// TODO Create the appropriate object
			if (racers != null){
				Path racersPath = racers.toPath();
				try {
					List<String> lines = Files.readAllLines(racersPath);
					for (String s : lines) {
						String[] rParams = s.split(",");
						rl.add(new Racer(rParams[0], rParams[1], rParams[2], rParams[3]));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Racer racer : rl) {
					System.out.println(racer);
				}
			}
			else {
				rl.add(new Racer(bibNumber.getText(), lastName.getText(),
						firstInitial.getText(), time.getText()));
				for (Racer racer : rl) {
					System.out.println(racer);
				}
			}

		} else {
			firstInitial.setEnabled(true);
    		lastName.setEnabled(true);
    		bibNumber.setEnabled(true);
    		time.setEnabled(true);
			System.out.println("Cancelled");
		}
	}
	
	public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            racers = chooser.getSelectedFile();
            firstInitial.setEnabled(false);
    		lastName.setEnabled(false);
    		bibNumber.setEnabled(false);
    		time.setEnabled(false);
            firstInitial.setBackground(Color.LIGHT_GRAY);
            lastName.setBackground(Color.LIGHT_GRAY);
            bibNumber.setBackground(Color.LIGHT_GRAY);
            time.setBackground(Color.LIGHT_GRAY);
        } else {
            // user changed their mind
        }
    }
}
