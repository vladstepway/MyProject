package sample;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector
{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException
    {
        String URL = "jdbc:mysql://localhost:3306/bsuir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driverName = "com.mysql.jdbc.Driver";
        String USER = "root";
        String PASSWORD = "root";
        Class.forName(driverName);

        this.dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connection successfull!");
        return this.dbConnection;
    }
}
