package Mastery;

// Import required Java AWT and Swing GUI libraries
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Schoolinputer {

    // GUI window components
    private JFrame frame;
    private JTextField FNtext;    // First Name input field
    private JTextField LNtext;    // Last Name input field
    private JTextField display;   // Summary output field

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread for thread safety
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Schoolinputer window = new Schoolinputer();
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
    public Schoolinputer() {
        initialize();
    }

    /**
     * Initialize the contents of the frame and setup components.
     */
    private void initialize() {
        
        // --- 1. IMAGE INITIALIZATION ---
        // Load high school logo image assets from relative project paths
        ImageIcon chhs = new ImageIcon("../Chapter10/src/Mastery/chhs.jpg");
        ImageIcon western = new ImageIcon("../Chapter10/src/Mastery/western.png");
        ImageIcon nhms = new ImageIcon("../Chapter10/src/Mastery/nmhs.png");
        ImageIcon bishop = new ImageIcon("../Chapter10/src/Mastery/bishop.jpg");
        ImageIcon NT = new ImageIcon("../Chapter10/src/Mastery/north trail.png");

        // --- 2. MAIN WINDOW FRAME ---
        frame = new JFrame();
        frame.setBounds(100, 100, 719, 668); // Set window position and dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on exit

        // Main panel content container using absolute positioning (null layout)
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // --- 3. FIRST NAME INPUT ---
        FNtext = new JTextField();
        // Clear placeholder text automatically when the user starts typing
        FNtext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(FNtext.getText().equals("Enter first name: ")) {
                    FNtext.setText("");
                    FNtext.setForeground(new Color(0, 0, 0)); // Change text color to black
                }
            }
        });
        FNtext.setForeground(new Color(192, 192, 192)); // Light gray placeholder color
        FNtext.setText("Enter first name: ");
        FNtext.setBounds(31, 26, 172, 29);
        panel.add(FNtext);
        FNtext.setColumns(10);

        // --- 4. LAST NAME INPUT ---
        LNtext = new JTextField();
        // Clear placeholder text automatically when the user starts typing
        LNtext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(LNtext.getText().equals("Enter Last Name: ")) {
                    LNtext.setText("");
                    LNtext.setForeground(new Color(0, 0, 0)); // Change text color to black
                }
            }
        });
        LNtext.setForeground(new Color(192, 192, 192)); // Light gray placeholder color
        LNtext.setText("Enter Last Name: ");
        LNtext.setBounds(229, 26, 175, 29);
        panel.add(LNtext);
        LNtext.setColumns(10);

        // --- 5. DROP-DOWN SELECTIONS (COMBO BOXES) ---
        // Grade level selection
        JComboBox grade = new JComboBox();
        grade.setModel(new DefaultComboBoxModel(new String[] {"Select your grade: ", "12", "11", "10"}));
        grade.setBounds(31, 83, 172, 29);
        panel.add(grade);

        // School selection
        JComboBox schooloptions = new JComboBox();
        schooloptions.setModel(new DefaultComboBoxModel(new String[] {"Select your school:", "Western", "Nelson Mandela", "Crescent Heights", "North Trail", "Bishop Carroll"}));
        schooloptions.setBounds(229, 83, 175, 29);
        panel.add(schooloptions);

        // --- 6. DISPLAY & LOGO OUTPUT ---
        // Text field to show final student info summary string
        display = new JTextField();
        display.setBounds(31, 123, 469, 110);
        panel.add(display);
        display.setColumns(10);

        // Label placeholder to dynamically hold the school's logo image
        JLabel schoolIcon = new JLabel("");
        schoolIcon.setBounds(58, 233, 500, 400);
        panel.add(schoolIcon);

        // --- 7. ACTION BUTTON (SUBMIT) ---
        JButton submit = new JButton("Submit");
        // Handle click event to compile user input and update visual elements
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch text inputs and dropdown selections
                String FN = FNtext.getText();
                String LN = LNtext.getText();
                String school = String.valueOf(schooloptions.getSelectedItem());
                String Grade = String.valueOf(grade.getSelectedItem());

                // Set summary sentence into the display text field
                display.setText(FN + " " + LN + " is in grade: " + Grade + " and goes to " + school + " High School");

                // Evaluate selection and update the school icon image accordingly
                if(school.equals("Western")) {
                    schoolIcon.setIcon(western);
                }
                if(school.equals("Nelson Mandela")) {
                    schoolIcon.setIcon(nhms);
                }
                if(school.equals("Crescent Heights")) {
                    schoolIcon.setIcon(chhs);
                }
                if(school.equals("North Trail")) {
                    schoolIcon.setIcon(NT);
                }
                if(school.equals("Bishop Carroll")) {
                    schoolIcon.setIcon(bishop);
                }
            }
        });
        submit.setBounds(525, 11, 146, 226);
        panel.add(submit);
    }
}
