import javax.swing.*;
import java.awt.*;

public class StudentProfilePage extends JFrame {
    private JDesktopPane desktopPane;

    public StudentProfilePage() {
        setTitle("Student Profile Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create desktop pane
        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        // Create split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createLeftPanel(), createRightPanel());
        splitPane.setDividerLocation(300); // Adjust the divider location for better layout
        desktopPane.add(splitPane);

        setVisible(true);
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Personal Info", createPersonalInfoPanel());
        tabbedPane.addTab("Courses", createCoursesPanel());

        panel.add(tabbedPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create internal frame
        JInternalFrame internalFrame = new JInternalFrame("Profile Picture", true, true, true, true);
        internalFrame.setSize(300, 300);
        internalFrame.setVisible(true);

        // Assuming profile_picture.png is in the project directory
        internalFrame.add(new JLabel(new ImageIcon("profile_picture.png")), BorderLayout.CENTER);

        // Add internal frame to desktop pane and make it visible
        desktopPane.add(internalFrame);
        try {
            internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }

        panel.add(internalFrame, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Personal Info fields with sample data
        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField(10);
        nameField.setText("John Doe");
        panel.add(nameField);

        panel.add(new JLabel("Roll No:"));
        JTextField rollNoField = new JTextField(10);
        rollNoField.setText("12345");
        panel.add(rollNoField);

        panel.add(new JLabel("Age:"));
        JTextField ageField = new JTextField(10);
        ageField.setText("21");
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        JTextField genderField = new JTextField(10);
        genderField.setText("Male");
        panel.add(genderField);

        panel.add(new JLabel("Address:"));
        JTextArea addressArea = new JTextArea(2, 10);
        addressArea.setText("123 Main St, Cityville");
        panel.add(addressArea);

        return panel;
    }

    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Course list with sample data
        JTextArea coursesArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(coursesArea);
        coursesArea.setText("Course 1: Mathematics\nCourse 2: Science\nCourse 3: History\nCourse 4: Literature"); // Sample courses

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentProfilePage());
    }
}
