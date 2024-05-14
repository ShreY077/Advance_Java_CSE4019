import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudentData {

    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/Student_Data";
        String username = "root";
        String password = "Shreyansh7";

       
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            connection = DriverManager.getConnection(url, username, password);

            
            statement = connection.createStatement();

            
            String sqlQuery = "SELECT * FROM student";
            resultSet = statement.executeQuery(sqlQuery);

            
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String studentName = resultSet.getString("name");
                int studentAge = resultSet.getInt("age");

                
                System.out.println("Student ID: " + studentId);
                System.out.println("Student Name: " + studentName);
                System.out.println("Student Age: " + studentAge);
                System.out.println("----------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
