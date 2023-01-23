package sideBySide;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondPage implements ActionListener  {
	
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Model 1");
	File modelOne = null;
	File modelTwo = null;
	JButton button2 = new JButton("Model 2");
	JButton button3 = new JButton("Output Location");
	JButton button4 = new JButton("Test Set");
	JButton button5 = new JButton("Bin Location");
	JButton button6 = new JButton("RUN");
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Test");
	JTextField input1 = new JTextField();
	JFileChooser j1 = new JFileChooser("C:\\Users\\suppo\\Desktop\\review files\\handball");
	JFileChooser j2 = new JFileChooser("C:\\Users\\suppo\\Desktop\\review files\\handball");
	JFileChooser j3 = new JFileChooser();
	JFileChooser j4 = new JFileChooser();
	JFileChooser j5 = new JFileChooser();
	
	SecondPage() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		button1.setBounds(5,10,200,40);
		button1.setFocusable(false);
		button1.addActionListener(this);
		frame.add(button1);
		
		button2.setBounds(200,10,200,40);
		button2.setFocusable(false);
		button2.addActionListener(this);
		frame.add(button2);
		
		button3.setBounds(200,100,200,40);
		button3.setFocusable(false);
		button3.addActionListener(this);
		frame.add(button3); //re-add this to show the button
		
		button4.setBounds(5,100,200,40);
		button4.setFocusable(false);
		button4.addActionListener(this);
		frame.add(button4); //re-add this to show the button
		
		button5.setBounds(100,200,200,40);
		button5.setFocusable(false);
		button5.addActionListener(this);
		frame.add(button5); //re-add this to show the button
		
		button6.setBounds(100,300,200,40);
		button6.setFocusable(false);
		button6.addActionListener(this);
		frame.add(button6); //re-add this to show the button
		
		}
	
	    public void createAndRunBAT(String directory, String command) {
	        // create a File object for the specified directory
	        File dir = new File(directory);
	        // check if the directory exists
	        if (!dir.exists()) {
	            System.out.println("Error: directory does not exist");
	            return;
	        }
	        // create a File object for the .bat file
	        File batFile = new File(dir, "script.bat");
	        try {
	            // create a PrintWriter to write the command to the .bat file
	            PrintWriter writer = new PrintWriter(batFile);
	            // write the command to the .bat file
	            writer.println(command);
	            // close the PrintWriter
	            writer.close();
	        } catch (IOException e) {
	            System.out.println("Error creating .bat file");
	            e.printStackTrace();
	            return;
	        }
	        try {
	            // run the .bat file using the Runtime exec method
	            // cmd /c start is used to open the .bat file in a new command prompt window
	            Runtime.getRuntime().exec("cmd /c start " + batFile.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Error running .bat file");
	            e.printStackTrace();
	        }
	    }
	
	private void CommandLine() {
		
		modelOne = j1.getSelectedFile();
		modelTwo = j2.getSelectedFile();
		
		String model1 = modelOne.toString();
		String model2 = modelTwo.toString();
		model1 = model1.substring(model1.lastIndexOf("\\") + 1);
		int index1 = model1.indexOf(".");
		model1 = model1.substring(0, index1);
		
		model2 = model2.substring(model2.lastIndexOf("\\") + 1);
		int index2 = model2.indexOf(".");
		model2 = model2.substring(0, index2);
		System.out.println(model1 + " " + model2); // debug test line
		
		String mLocation = modelOne.getParent();
		System.out.println(mLocation); //debug test line
		
		String testSetLocale = j3.getSelectedFile().toString();
		System.out.println(testSetLocale);
		
		String outputFolder = j4.getSelectedFile().toString();
		System.out.println(outputFolder);
		
		String fullCmd = "python compare.py " + model1 + " " + model2 + " " + mLocation + " " + testSetLocale + " " + outputFolder; 
		System.out.println("command succesfully generated from files and directories.");
		
		String bin = j5.getSelectedFile().toString();
		System.out.println("bin is " + bin);
		
		createAndRunBAT(bin, fullCmd);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button1) {
			j1.showSaveDialog(button1);
			modelOne = j1.getSelectedFile();
		}
		
		if(e.getSource()==button2) {
			j2.showSaveDialog(button2);
		}
		
		if(e.getSource()==button3) {
			j4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			j4.showSaveDialog(button4);
		}
		
		if(e.getSource()==button4) {
			j3.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			j3.showSaveDialog(button4);
		}
		
		if(e.getSource()==button5) {
			j5.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			j5.showSaveDialog(button5);
		}
			
		if(e.getSource()==button6) {
			System.out.println("button 6 pressed");
			CommandLine();
			
		}

			
		
		
		}
		
	
	
	}


