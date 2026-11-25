package config;
import java.sql.*;
/**
 *
 * @author daniilocl
 */
public class ConectaBanco {
    public static Connection conectar(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
        } catch (Exception ex) {
            System.out.println("Erro - SQL: " + ex);
        }
        
        return conn;
    }
}

