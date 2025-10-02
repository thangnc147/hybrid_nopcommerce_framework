package jbdcConfigs;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJBDCConfig {

    public static Connection getSQLServerConnection() {
        String hostName = "localhost";
        String sqlInstanceName = "NOPCOMMERCE";
        String database = "nopcommerce";
        String userName = "sa";
        String password = "AH3342YAASKDZIQ";
        return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
    }

    private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cấu trúc URL Connection dành cho SQL Server
            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName +
                    ";databaseName=" + database + ";encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}