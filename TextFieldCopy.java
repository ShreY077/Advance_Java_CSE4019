import java.awt.*;
import java.awt.event.*;

public class TextFieldCopy extends Frame implements ActionListener {
    // Text fields
    private TextField textField1;
    private TextField textField2;

    // Button
    private Button copyButton;

    public TextFieldCopy() {
        // Set the title of the window
        setTitle("Text Field Copy");

        // Create text fields
        textField1 = new TextField(20);
        textField2 = new TextField(20);

        // Create button
        copyButton = new Button("Copy");
        // Add action listener to the button
        copyButton.addActionListener(this);

        // Create panel to hold components
        Panel panel = new Panel();
        // Add text fields and button to the panel
        panel.add(textField1);
        panel.add(copyButton);
        panel.add(textField2);

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

    // Action performed when button is clicked
    public void actionPerformed(ActionEvent e) {
        // Check if the action command is from the copy button
        if (e.getSource() == copyButton) {
            // Copy text from textField1 to textField2
            textField2.setText(textField1.getText());
        }
    }

    public static void main(String[] args) {
        new TextFieldCopy();
    }
}