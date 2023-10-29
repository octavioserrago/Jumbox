package DATA;

import java.sql.DriverManager;
import java.sql.Connection; 
import javax.swing.JOptionPane;

public class DatabaseConnection {
    Connection con; 

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jumbox", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse");
        }
        return con;
    }
}
