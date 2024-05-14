import javax.swing.*;

public class WidgetDemo {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Widget Demo");
        frame.setSize(400, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel("This is a Label");
        frame.add(label);


        
        frame.setVisible(true);
    }
}
