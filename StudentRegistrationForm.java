import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    // Components
    private JTextField nameField, rollNoField, courseField;
    private JPasswordField passwordField;
    private JTextArea addressArea;
    private JButton submitButton;

    public StudentRegistrationForm() {
        setTitle("Student Course Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        // Labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel rollNoLabel = new JLabel("Roll No:");
        rollNoField = new JTextField(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JLabel courseLabel = new JLabel("Course:");
        courseField = new JTextField(15);

        JLabel addressLabel = new JLabel("Address:");
        addressArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(addressArea);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(rollNoLabel);
        panel.add(rollNoField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(courseLabel);
        panel.add(courseField);
        panel.add(addressLabel);
        panel.add(scrollPane);
        panel.add(submitButton);

        // Add panel to the frame
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String rollNo = rollNoField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            String course = courseField.getText();
            String address = addressArea.getText();

            // Display submitted information (you can process this further as needed)
            JOptionPane.showMessageDialog(this,
                    "Name: " + name + "\n" +
                            "Roll No: " + rollNo + "\n" +
                            "Password: " + password + "\n" +
                            "Course: " + course + "\n" +
                            "Address: " + address,
                    "Registration Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationForm());
    }
}
