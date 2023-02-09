import java.sql.*;
import java.util.ArrayList;
import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        ResultSet resultSet;
        Statement statement;

        try {
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "creative1";

            conn = getConnection(url, user, password);

            statement = conn.createStatement();

            String data = "SELECT first_name, last_name FROM students";

            resultSet = statement.executeQuery(data);

            ArrayList<String> surnames = new ArrayList<> ();

            while (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);

                System.out.println(firstName + " " + lastName);

                surnames.add(lastName);
            }

            System.out.println(surnames);


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
