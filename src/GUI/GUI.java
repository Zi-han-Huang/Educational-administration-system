package GUI;

import java.io.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUI implements ActionListener{
	
	private static JButton dirButton, adminButton, trainButton;
	private static JTextArea requireText,teacherText;
	public static JTextArea trainText;
	private static JLabel requireLabel, teacherLabel;
	static JFrame frame = new JFrame("Welcome to PTT System");
	
	public static void main(String[] args){
	frame.setSize(900, 700);
	frame.setLocation(350, 80);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	dirButton = new JButton(" Class Director ");
	dirButton.addActionListener(new GUI());
	trainButton = new JButton(" find teacher for training ");
	trainButton.addActionListener(new GUI());
	
	adminButton = new JButton(" Administrator ");
	adminButton.addActionListener(new GUI());
	
	requireLabel = new JLabel("requirement list", JLabel.CENTER);
	teacherLabel = new JLabel("teacher list", JLabel.CENTER);
	
	
	requireText = new JTextArea();
	teacherText = new JTextArea();
	trainText = new JTextArea();
	
	GridLayout g1 = new GridLayout();
	g1.setColumns(2);
	g1.setRows(4);
	frame.setLayout(g1);

	frame.add(dirButton);
	frame.add(adminButton);
	frame.add(requireLabel); requireLabel.setVisible(false);
	frame.add(requireText);  requireText.setVisible(false);
	frame.add(teacherLabel); teacherLabel.setVisible(false);
	frame.add(teacherText);  teacherText.setVisible(false);
	frame.add(trainButton);	 trainButton.setVisible(false);
	frame.add(trainText);	 trainText.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(" Class Director ")) {
			frame.setExtendedState(JFrame.ICONIFIED);
			Console con = new Console();
			con.main();
		}
			
		if (e.getActionCommand().equals(" Administrator ")) {
			
			requireLabel.setVisible(true);
			requireText.setVisible(true);
			teacherLabel.setVisible(true);
			teacherText.setVisible(true);
			trainButton.setVisible(true);
			trainText.setVisible(true);
			
			try {
				File file = new File("src\\people\\RequirementList.txt");
				FileReader filereader = new FileReader(file);
				BufferedReader bufferreader = new BufferedReader(filereader);
				String aline;
				while((aline = bufferreader.readLine())!= null)
					requireText.append(aline+"\r\n");
				filereader.close();
				bufferreader.close();
	
			} catch (IOException e1) {System.err.print("TeacherList not found!!!");}
			
			try {
				File file = new File("src\\people\\TeacherList.txt");
				FileReader filereader = new FileReader(file);
				BufferedReader bufferreader = new BufferedReader(filereader);
				String aline;
				while((aline = bufferreader.readLine())!= null)
					teacherText.append(aline+"\r\n");
				filereader.close();
				bufferreader.close();
	
			} catch (IOException e1) {System.err.print("TeacherList not found!!!");}
			
		}
		if (e.getActionCommand().equals(" find teacher for training ")) {
			trainText.append("Administrator find suitable staff for training");
		}
	}
}


