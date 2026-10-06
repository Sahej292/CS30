package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class rollDice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rollDice window = new rollDice();
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
	public rollDice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		ImageIcon die1 = new ImageIcon("../Chapter10/src/SkillBuilders/die1.gif"); // importing image 
		ImageIcon die2 = new ImageIcon("../Chapter10/src/SkillBuilders/die2.gif"); 
		ImageIcon die3 = new ImageIcon("../Chapter10/src/SkillBuilders/die3.gif"); 
		ImageIcon die4 = new ImageIcon("../Chapter10/src/SkillBuilders/die4.gif"); 
		ImageIcon die5 = new ImageIcon("../Chapter10/src/SkillBuilders/die5.gif"); 
		ImageIcon die6 = new ImageIcon("../Chapter10/src/SkillBuilders/die6.gif"); 
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel dieface = new JLabel("");
		dieface.setBounds(79, 197, 176, 152);
		panel.add(dieface);
		
		JLabel dieface2 = new JLabel("");
		dieface2.setBounds(174, 199, 176, 140);
		panel.add(dieface2);
		
		JButton rolldie = new JButton("Roll Dice ");
		rolldie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int newRoll, newRoll2;
				
				newRoll= (int)(6* Math.random() + 1);
				
				if (newRoll == 1 ) {
					dieface.setIcon(die1);
					
				}
				
				
				else if (newRoll == 2 ) {
					dieface.setIcon(die2);
					
				}
				else if (newRoll == 3 ) {
					dieface.setIcon(die3);
					
				}
				else if (newRoll == 4 ) {
					dieface.setIcon(die4);
					
				}
				else if (newRoll == 5 ) {
					dieface.setIcon(die5);
				}
				
					else if (newRoll == 6 ) {
						dieface.setIcon(die6);
						
					}
				
			
			
			
			newRoll2= (int)(6* Math.random() + 1);
			
			if (newRoll2 == 1 ) {
				dieface2.setIcon(die1);
				
			}
			
			
			else if (newRoll2 == 2 ) {
				dieface2.setIcon(die2);
				
			}
			else if (newRoll2 == 3 ) {
				dieface2.setIcon(die3);
				
			}
			else if (newRoll2 == 4 ) {
				dieface2.setIcon(die4);
				
			}
			else if (newRoll2 == 5 ) {
				dieface2.setIcon(die5);
			}
			
				else if (newRoll2 == 6 ) {
					dieface2.setIcon(die6);
					
				}
			}
			
		});
		
			
			
		
		rolldie.setBounds(51, 25, 265, 62);
		panel.add(rolldie);
		
	
			}
		}
		

		
