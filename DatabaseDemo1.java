import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseDemo1 extends Frame implements ActionListener
 {
    private TextField nameField, ageField, idField;
    private Button addButton, updateButton, deleteButton;
    private Label messageLabel;
    private Connection connection;

    public DatabaseDemo1() 
    {
        super("Database Demo");

        // Create text fields
        nameField = new TextField(10);
        ageField = new TextField(10);
        idField = new TextField(10);

        // Create buttons
        addButton = new Button("Add");
        addButton.addActionListener(this);
        updateButton = new Button("Update");
        updateButton.addActionListener(this);
        deleteButton = new Button("Delete");
        deleteButton.addActionListener(this);

        // Create message label
        messageLabel = new Label("");

        // Add components to window
        setLayout(new FlowLayout());
        add(new Label("Name:"));
        add(nameField);
        add(new Label("Age:"));
        add(ageField);
        add(new Label("ID:"));
        add(idField);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(messageLabel);

        // Connect to MySQL database
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Shreyansh7");
        } 
        catch 
        (Exception ex) 
        {
            messageLabel.setText("Error connecting to database: " + ex.getMessage());
        }

        // Set window size and visibility
        setSize(500, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            Statement statement = connection.createStatement();
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            int id = Integer.parseInt(idField.getText());

            if (e.getSource() == addButton) 
            {
                String sql ="INSERT INTO mytable (name, age, id) VALUES ('" + name + "', " + age + ", " + id + ")";
                System.out.println(sql);
                statement.executeUpdate("INSERT INTO mytable (name, age, id) VALUES ('" + name + "', " + age + ", " + id + ")");
                messageLabel.setText("Record added successfully");
            } 
            else if (e.getSource() == updateButton) 
            {   
                String sqlUPdate="UPDATE mytable SET name = '" + name + "', age = " + age + " WHERE id = " + id;
                System.out.println(sqlUPdate);
                statement.executeUpdate("UPDATE mytable SET name = '" + name + "', age = " + age + " WHERE id = " + id);
                messageLabel.setText("Record updated successfully");
            }
             else if (e.getSource() == deleteButton) 
             {
                statement.executeUpdate("DELETE FROM mytable WHERE id = " + id);
                
                messageLabel.setText("Record deleted successfully");
            }
        } 
        catch (Exception ex) 
        {
            messageLabel.setText("Error performing operation: " + ex.getMessage());
        }
    }

    public static void main(String[] args) 
    {
        new DatabaseDemo1();
    }
}