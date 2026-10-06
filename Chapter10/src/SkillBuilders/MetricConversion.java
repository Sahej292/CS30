package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MetricConversion {

	private JFrame frame;
	private JTextField textField;
	private JTextField Fc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Click on your conversion type!", "feet = 0.3048 meters ", "1 inch = 2.54 cm ", "1 pound = 0.4536", "1 gallon = 4.5461 litres"}));
		comboBox.setBounds(88, 8, 236, 56);
		panel.add(comboBox);
		
		
		
		JLabel display = new JLabel("");
		display.setBounds(64, 174, 302, 65);
		panel.add(display);
		
		
		Fc = new JTextField();
		Fc.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				
				if(Fc.getText().equals("Enter your number here: "))
				{
					Fc.setText(null);
				}
				
			}
		});
		Fc.setText("Enter your number here: ");
		Fc.setBounds(98, 75, 229, 56);
		panel.add(Fc);
		Fc.setColumns(10);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
		{
			if(comboBox.getSelectedItem().equals("feet = 0.3048 meters ")) 
			{
					String n = Fc.getText();
					double Num = Double.parseDouble(n); // getting rid of the quotation marks 
					double ans = Num* 0.3048;
					
					display.setText(Num + " feet converted to m is:" + ans + " m");
				
				}
				 if(comboBox.getSelectedItem().equals("1 inch = 2.54 cm "))
				 {
					String n1 = Fc.getText();
					double Num1 = Double.parseDouble(n1); // getting rid of the quotation marks 
					double ans1 = Num1* 2.54;
				
					display.setText(Num1 + " inches converted to cm is:"
										+ ans1 + " cm"); }
			
				
				if(comboBox.getSelectedItem().equals("1 pound = 0.4536"))
				{
				String n2 = Fc.getText();
				double Num2 = Double.parseDouble(n2); // getting rid of the quotation marks 
				double ans2 = Num2* 0.4536;
				
				display.setText(Num2 + " pound converted to kilogram is:"
										+ ans2 + " kg"); 
				}
				
				
				 if(comboBox.getSelectedItem().equals("1 gallon = 4.5461 litres")) 
				 {
				String n3 = Fc.getText();
				double Num3 = Double.parseDouble(n3); // getting rid of the quotation marks 
				double ans3 = Num3* 4.5461;
				
				display.setText(Num3 + " gallons converted to litres is:"
										+ ans3 + " kg"); 
				}
				
				
				
				
			}
		});
		
		
		
	
	
	}
}
