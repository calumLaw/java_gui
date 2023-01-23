package sideBySide;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstPage implements ActionListener {
	
	JFrame frame = new JFrame(); 
	JButton sideBySide = new JButton("Side by Side");
	JButton quad = new JButton("Quad Split");
	JLabel footer = new JLabel("An unnecessary program");
	JPanel panel = new JPanel();
	
	FirstPage(){
		
		sideBySide.setBounds(200,160,200,40);
		sideBySide.setFocusable(false);
		sideBySide.addActionListener(this);
		
		quad.setBounds(0,160,200,40);
		quad.setFocusable(false);
		quad.addActionListener(this);
		
		footer.setFocusable(true);
		footer.setBounds(130, 50, 1000, 50);
		
		panel.add(footer);
		
		frame.add(footer);
		frame.add(sideBySide);
		frame.add(quad);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==sideBySide) {
			SecondPage sideBySidePage = new SecondPage();
			frame.setVisible(false);
		}
		
		
	}

}
