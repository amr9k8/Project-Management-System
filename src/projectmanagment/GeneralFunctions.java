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
public class GeneralFunctions {
 
     
   public Connection conn = null; //To Create Connection
   public Statement stmt = null; //To Send Queries
   public ResultSet rs = null;//To Save Result From Select Query
   
  public GeneralFunctions() {
   conn = DBConnect.StartConnection();   

}
  
  
public ResultSet getAllMembers()
{      
    String sql = "SELECT * FROM `members`"; //query
    
         try {
             
           // set stmt to send query
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);              
           return rs;   
           
       } catch(Exception ex) {
           System.out.println("Error: "+ex);
           return null;
       }
    
          
}


//Return 0 IF User Enterd Wrong Data And Return His ID iF Data is Correct !
public  int loginMember(String name , String pass)
{
     int id = 0;  //variable to save logged in person
    String sql = "SELECT * FROM `members` WHERE `name` = \""+name+"\" AND`password`= \""+pass+"\""; //query
        try {
           // System.out.println(sql);//for testing
           // set stmt to create statement
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);
           
           // check if ResultSet is not empty
            if (rs.next() == true )
                id = rs.getInt("id");
            
                return id; //0 if user not found or certain id if user is found

          } catch(Exception ex) {
           System.out.println("Error: "+ex);
           return 0;
       }
    
          
}
   
  


/**
 * 
 * @param personId
 * @return String role  (Member/Leader)  !
 */
public  String checkRole(int personId)
{
    String sql = "SELECT * FROM `members` WHERE `id` = "+personId; //query
    String role = ""; //null by default
        try {
            //System.out.println(sql);
           // set stmt to send queries
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);
           rs.next();
           role = rs.getString("role");
           return role;
           
       } catch(Exception ex) {
           System.out.println("Error: "+ex);
           return role;
       }
    
           
}
   
    
    
    
}




