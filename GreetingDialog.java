import java.awt.*;
import java.awt.event.*;

public class GreetingDialog extends Frame implements ActionListener {
    // Components
    private Label nameLabel;
    private TextField nameTextField;

    public GreetingDialog() {
        // Set the title of the window
        setTitle("Greeting Dialog");

        // Create label
        nameLabel = new Label("Enter your name:");
        
        // Create text field
        nameTextField = new TextField(20);
        // Add action listener to the text field
        nameTextField.addActionListener(this);

        // Create panel to hold components
        Panel panel = new Panel();
        // Add label and text field to the panel
        panel.add(nameLabel);
        panel.add(nameTextField);

        // Set layout for the frame
        setLayout(new FlowLayout());

        // Add panel to the frame
        add(panel);

        // Set size of the frame
        setSize(300, 100);

        // Make the frame visible
        setVisible(true);

        // Close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // Action performed when enter key is pressed in the text field
    public void actionPerformed(ActionEvent e) {
        // Get the text entered in the text field
        String name = nameTextField.getText();
        // Show message dialog with greeting
        showMessageDialog("Hello, " + name);
    }

    // Method to display message dialog
    private void showMessageDialog(String message) {
        // Create message dialog
        Dialog dialog = new Dialog(this, "Greeting");
        Label label = new Label(message);
        dialog.add(label);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new GreetingDialog();
    }
}
