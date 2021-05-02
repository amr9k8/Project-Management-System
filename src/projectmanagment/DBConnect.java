/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagment;
import java.sql.*;
/**
 *
 * @author root
 */
        
public class DBConnect {
   // Create a connection variable and set it to null
   Connection conn = null;
   
    public static Connection StartConnection() //Method To Start Connection
    {
         // Provide a try and catch exception
        try {
            // jdbc:mysql://hostname:port/databasename, server username, server password
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projectmangment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            return conn;
            
        }catch(Exception ex) {
            // If connection fail
            System.out.println("Erro: " + ex);
            return null;
        }

    }
    
}

