import java.sql.*;
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

            String data = "SELECT first_name, last_name, FROM newdb.students";

            resultSet = statement.executeQuery(data);

            while (resultSet.next()) {
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);

                System.out.println(firstName + " " +lastName + " ");
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
