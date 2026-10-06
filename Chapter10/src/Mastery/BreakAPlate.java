package Mastery;

// Import required Java AWT and Swing GUI libraries
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class BreakAPlate {

	// GUI window components
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Run the GUI creation on the Event Dispatch Thread for thread safety
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
					window.frame.setVisible(true); // Make the window visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BreakAPlate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame and setup components.
	 */
	private void initialize() {
		
		// --- 1. IMAGE/GIF INITIALIZATION ---
		// Load game graphics from relative project asset paths
		ImageIcon placeholder = new ImageIcon("../Chapter10/src/Mastery/placeholder.gif");
		ImageIcon abrokenp = new ImageIcon("../Chapter10/src/Mastery/plates_all_broken.gif");
		ImageIcon twobrokenplates = new ImageIcon("../Chapter10/src/Mastery/plates_two_broken.gif");
		ImageIcon plates = new ImageIcon("../Chapter10/src/Mastery/plates.gif");
		ImageIcon sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.gif");
		ImageIcon tplush = new ImageIcon("../Chapter10/src/Mastery/tiger_plush.gif");
		
		// --- 2. MAIN WINDOW FRAME ---
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 418); // Set window layout position and size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on exit
		
		// Main panel container using absolute positioning (null layout)
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// --- 3. VISUAL DISPLAY LABELS ---
		// Label to display the status of the target plates (starts fully intact)
		JLabel plates1 = new JLabel("");
		plates1.setBounds(76, 11, 297, 127);
		panel.add(plates1);
		plates1.setIcon(plates);
		
		// Label to display the won prize graphics or losing text
		JLabel display = new JLabel("");
		display.setBounds(149, 166, 261, 231);
		panel.add(display);
		
		// --- 4. GAME ACTION BUTTON ---
		JButton play = new JButton("Play");
		// Handle click event to process game rounds and randomize scores
		play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String eventName = play.getActionCommand(); // Fetches text on the button
				
				display.setText(null); // Clear any losing text from previous rounds
				
				// Generate a random integer between 1 and 3 to determine outcome
				int newPlay = (int)(Math.random() * 3) + 1;
				 
				// Toggle button label text back and forth between rounds
				if (play.getText().equals("Play!")) {
					play.setText("Play Again!");
				} 
				else {
					play.setText("Play!");
				}
				 
				// --- 5. GAME OUTCOME RESOLUTION ---
				// Outcome 1: Best result! All plates broken, win the Tiger Plush first prize
				if (newPlay == 1) {
					plates1.setIcon(abrokenp);
					display.setIcon(tplush);
				}
				 
				// Outcome 2: Moderate result. Two plates broken, win a sticker consolation prize
				if (newPlay == 2) {
					plates1.setIcon(twobrokenplates);
					display.setIcon(sticker);
				}
				 
				// Outcome 3: Worst result. No plates broken, remove prize icon and show lose message
				if (newPlay == 3) {
					plates1.setIcon(plates);
					display.setIcon(null);
					display.setText("You lost :C");
				}
			}
		});
		play.setBounds(117, 129, 180, 59);
		panel.add(play);
	}
}


