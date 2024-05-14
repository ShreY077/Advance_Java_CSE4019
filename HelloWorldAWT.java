import java.awt.*;

public class HelloWorldAWT extends Frame {
    
    public HelloWorldAWT() {
        // Set the title of the window
        setTitle("Hello, VIT");
        
        // Create a label
        Label label = new Label("Hello, VIT");
        
        // Add the label to the frame
        add(label);
        
        // Set the size of the frame
        setSize(200, 100);
        
        // Set the layout to BorderLayout (default layout for Frame)
        setLayout(new BorderLayout());
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
        
        // Make the frame visible
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Create an instance of HelloWorldAWT
        new HelloWorldAWT();
    }
}
