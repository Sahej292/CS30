package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class semesterAverage {

	private JFrame frame;
	private JLabel display;
	private JTextField Gr1;
	private JTextField Gr2;
	private JTextField Gr3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					semesterAverage window = new semesterAverage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public semesterAverage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Gr1 = new JTextField();
		Gr1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Gr1.getText().equals("Enter the first grade: "))
		{
			Gr1.setText("");
		}
			}
		});
		Gr1.setText("Enter the first grade: ");
		Gr1.setBounds(34, 11, 155, 67);
		frame.getContentPane().add(Gr1);
		Gr1.setColumns(10);
		
		Gr2 = new JTextField();
		Gr2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Gr2.getText().equals("Enter the second grade: "))
				{
					Gr2.setText("");
				}
			}
		});
		Gr2.setText("Enter the second grade: ");
		Gr2.setColumns(10);
		Gr2.setBounds(34, 89, 155, 67);
		frame.getContentPane().add(Gr2);
		
		JLabel display = new JLabel("");
		display.setBounds(34, 243, 209, 56);
		frame.getContentPane().add(display);
	
		Gr3 = new JTextField();
		Gr3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				if(Gr3.getText().equals("Enter the third grade: "))
				{
					Gr3.setText("");
				}
			
			}
		});
		
		Gr3.setText("Enter the third grade: ");
		Gr3.setColumns(10);
		Gr3.setBounds(34, 167, 155, 67);
		frame.getContentPane().add(Gr3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fGr = Gr1.getText();
				String sGr = Gr2.getText();
				String tGr = Gr3.getText();
				
				double FGr = Double.parseDouble(fGr);
				double SGr = Double.parseDouble(sGr);
				double TGr = Double.parseDouble(tGr);
				
				double avgGrade = (FGr + SGr + TGr)/3;
				
				DecimalFormat dc  = new DecimalFormat("0.0");
				
				display.setText("Your semester average is " + dc.format(avgGrade));
				
				
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(211, 21, 119, 213);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		 
		 String g1 = Gr1.getText();
		 String g2 = Gr2.getText();
		 String g3 = Gr3.getText();
		 
		 double Fgr = Double.parseDouble(g1);
		 double Sgr= Double.parseDouble(g2);
		 double Tgr= Double.parseDouble(g3);
		 
		 double avgGrade = (Fgr +Sgr + Tgr)/3;
		 
		 DecimalFormat dc= new DecimalFormat("0.0");
		 
		
		 
		 display.setText("Your semester average is:"
				 		+ dc.format(avgGrade));
		 
		 
				
	
}
	}





