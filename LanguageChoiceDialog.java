import java.awt.*;
import java.awt.event.*;

public class LanguageChoiceDialog extends Frame implements ActionListener {
    // Components
    private Label label;
    private Choice choice;
    private Button button;

    public LanguageChoiceDialog() {
        // Set the title of the window
        setTitle("Language Choice Dialog");

        // Create label
        label = new Label("Choose your favorite programming language:");
        
        // Create choice component
        choice = new Choice();
        // Add options to the choice component
        choice.add("Java");
        choice.add("Python");
        choice.add("C#");
        choice.add("C/C++");
        
        // Create button
        button = new Button("Choose");
        // Add action listener to the button
        button.addActionListener(this);

        // Create panel to hold components
        Panel panel = new Panel();
        // Add label, choice, and button to the panel
        panel.add(label);
        panel.add(choice);
        panel.add(button);

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

    // Action performed when button is pressed
    public void actionPerformed(ActionEvent e) {
        // Get the selected language
        String selectedLanguage = choice.getSelectedItem();
        // Show message dialog with selected language
        showMessageDialog("You chose: " + selectedLanguage);
    }

    // Method to display message dialog
    private void showMessageDialog(String message) {
        // Create message dialog
        Dialog dialog = new Dialog(this, "Language Choice");
        Label label = new Label(message);
        dialog.add(label);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new LanguageChoiceDialog();
    }
}
