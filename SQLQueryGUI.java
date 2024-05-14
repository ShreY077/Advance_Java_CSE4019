import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SQLQueryGUI extends JFrame {
    private JTextField sqlQueryTextField;
    private JTextField filterTextField;
    private JTextArea resultTextArea;

    public SQLQueryGUI() {
        super("SQL Query GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sqlQueryTextField = new JTextField();
        filterTextField = new JTextField();
        JButton executeButton = new JButton("Execute Query");
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(new JLabel("SQL Query:"));
        inputPanel.add(sqlQueryTextField);
        inputPanel.add(new JLabel("Filter:"));
        inputPanel.add(filterTextField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(executeButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performQuery();
            }
        });
    }

    private void performQuery() {
        String sqlQuery = sqlQueryTextField.getText();
        String filter = filterTextField.getText();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root", "Shreyansh7");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            // Set parameters for the prepared statement (if needed)
            // preparedStatement.setString(1, someValue);

            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder resultText = new StringBuilder();

            // Retrieve metadata to get column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Iterate over rows in the result set
            while (resultSet.next()) {
                // Iterate over columns in each row
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);

                    // Apply filter (modify as needed)
                    if (columnValue.contains(filter)) {
                        resultText.append(columnName).append(": ").append(columnValue).append("\t");
                    }
                }
                resultText.append("\n");
            }

            resultTextArea.setText(resultText.toString());

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error executing query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading MySQL JDBC driver", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> {
            SQLQueryGUI gui = new SQLQueryGUI();
            gui.setVisible(true);
        });
    }
}
