import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement statement;
        ResultSet rs = null;

        List <Student> italianStudents = new ArrayList();
        List <Student> germanStudents = new ArrayList();

        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "creative1";

            conn = getConnection(url, user, password);

            statement = conn.createStatement();

            String italianView = "CREATE OR REPLACE VIEW italian_students AS " +
                    "SELECT last_name, first_name " +
                    "FROM students " +
                    "WHERE country = 'Italy' ";
            statement.executeUpdate(italianView);

            String germanView = "CREATE OR REPLACE VIEW german_students AS " +
                    "SELECT last_name, first_name " +
                    "FROM students " +
                    "WHERE country = 'Germany' ";
            statement.executeUpdate(germanView);


            String selectItalian = "SELECT *  FROM italian_students";
            rs = statement.executeQuery(selectItalian);

            String selectGerman = "SELECT * FROM german_students";
            rs = statement.executeQuery((selectGerman));

            while (rs.next()) {
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                Student student = new Student();
                italianStudents.add(student);
                germanStudents.add(student);

            }





        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}