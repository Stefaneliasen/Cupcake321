package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://146.185.160.162:3306/cupcakev123";
    private static final String USER = "stefan";
    private static final String PASSWORD = "Awesome1";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
    }
}
