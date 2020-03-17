package persistenceLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
    public static Connection getConnection() //working
    {
    Connection connection = null;
    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("hi");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms?verifyServerCertificate=false&useSSL=true", "root", "12345");
        if(connection!=null)
        {
            System.out.println("connected");
        }
        } catch (Exception e)
        {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    return connection;
    }
    public static void main(String args[])
    {
        Database db = new Database();
        Database.getConnection();
    }
}