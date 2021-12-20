package farmers_friend;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DataBaseConnection {

    Connection con;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con
                    = DriverManager.getConnection("jdbc:mysql://localhost/farmEasy", "root", "suba");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return con;
    }
}
