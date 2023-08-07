package Class_DBHelder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelder_SQL {

    public static Connection getDbConnection() {
        Connection con = null;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QLQUANCAPHE;"
                + "user=sa;" + "password=123;"
                + "encrypt=true;trustServerCertificate=true;";
        try {
            //Ket noi sql server
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection success");
        } catch (SQLException ex) {
            System.out.println("Ket noi loi");
            ex.printStackTrace();
        }
        return con;
    }
}
