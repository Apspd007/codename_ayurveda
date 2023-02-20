package com.ggv.ayurveda;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection
{
    public Connection getDBConnection()
    {
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@Thanendra:1521:xe", "system", "system");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-9QQ2DH6:1522:xe", "system", "user");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
            return null;
        }
    }
}