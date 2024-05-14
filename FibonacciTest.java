import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fibonacci Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(10);
        JButton generateButton = new JButton("Generate");
        JLabel resultLabel = new JLabel("Fibonacci Number: ");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(inputField.getText());
                    int fibonacciNumber = FibonacciGenerator.calculateFibonacci(n);
                    resultLabel.setText("Fibonacci Number: " + fibonacciNumber);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        frame.add(new JLabel("Enter n: "));
        frame.add(inputField);
        frame.add(generateButton);
        frame.add(resultLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
