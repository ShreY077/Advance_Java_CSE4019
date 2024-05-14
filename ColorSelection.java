import java.awt.*;
import java.awt.event.*;

public class ColorSelection extends Frame implements ActionListener {
    // Components
    private Label label;
    private CheckboxGroup checkboxGroup;
    private Button button;

    public ColorSelection() {
        // Set the title of the window
        setTitle("Color Selection");

        // Create label
        label = new Label("Select a color:");

        // Create checkbox group
        checkboxGroup = new CheckboxGroup();
        
        // Create radio buttons for colors
        Checkbox redCheckbox = new Checkbox("Red", checkboxGroup, false);
        Checkbox greenCheckbox = new Checkbox("Green", checkboxGroup, false);
        Checkbox blueCheckbox = new Checkbox("Blue", checkboxGroup, false);

        // Create button
        button = new Button("Apply");
        // Add action listener to the button
        button.addActionListener(this);

        // Create panel to hold components
        Panel panel = new Panel();
        // Add label and radio buttons to the panel
        panel.add(label);
        panel.add(redCheckbox);
        panel.add(greenCheckbox);
        panel.add(blueCheckbox);
        // Add button to the panel
        panel.add(button);

        // Set layout for the frame
        setLayout(new FlowLayout());

        // Add panel to the frame
        add(panel);

        // Set size of the frame
        setSize(300, 150);

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
        // Get the selected color
        String selectedColor = checkboxGroup.getSelectedCheckbox().getLabel();
        
        // Change the background color of the frame based on the selected color
        switch (selectedColor) {
            case "Red":
                setBackground(Color.RED);
                break;
            case "Green":
                setBackground(Color.GREEN);
                break;
            case "Blue":
                setBackground(Color.BLUE);
                break;
        }
    }

    public static void main(String[] args) {
        new ColorSelection();
    }
}
