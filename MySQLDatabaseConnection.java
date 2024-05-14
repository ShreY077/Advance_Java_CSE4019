import java.sql.*;

public class MySQLDatabaseConnection {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Define the connection URL, username, and password
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "your_username";
            String password = "your_password";

            // 3. Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // 4. Execute SQL queries
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EmployeeDetails";
            rs = stmt.executeQuery(sql);

            // 5. Process the results
            while (rs.next()) {
                // Assuming EmployeeDetails table has columns: ID, Name, Age, Salary
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                double salary = rs.getDouble("Salary");
                
                // Output employee details
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
