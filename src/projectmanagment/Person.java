/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package projectmanagment;
import java.sql.*;
/**
 *
 * @author Me
 */
abstract public class Person {

  
 //Person Variables   
   protected int id;
   protected String username;
   protected String password;
   protected String team_id;
   protected String role;
 

   
  //__________for DB_____________________________________________
  protected   Connection conn = null; //To Create Connection
  protected   Statement stmt = null; //To Send Queries
  protected   ResultSet rs = null;//To Save Result From Select Query
    
    /**
     *Constructor Call Function To Start Connection From DBConnect Class
     */
    public Person ()
{                                 
   conn = DBConnect.StartConnection(); 
} 
   //__________for DB_____________________________________________
  
 
    
    
    
    
  //NOTE THIS FUNCTION TO BROWSE ALL TASKS ,return all rows of task table
public ResultSet getAllTasks() 
{   
    String sql = "SELECT * FROM `task`"; //query
    
        try
        {
           // set stmt to create statement
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);
           
           return rs;
        }
    catch(Exception ex) 
    {System.out.println("Error: "+ex); }
        
        return rs;
}







   //NOTE THIS FUNCTION TO Return only EVERY TASK Assigned to Team's Member and Leader
public ResultSet getAllAssignedTasks() 
{   
    String sql = "SELECT * FROM `table_collection`"; //query
    
        try
        {
           // set stmt to create statement
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);
           
           return rs;
        }
    catch(Exception ex) 
    {System.out.println("Error: "+ex); }
        
        return rs;
}





public  ResultSet getPersonTasksById(int id)
{

    String sql = "SELECT * FROM `table_collection` WHERE `member_id` = "+id; //query
        try
        {
           // set stmt to create statement
           stmt = conn.createStatement(); 
           rs = stmt.executeQuery(sql);
           
           return rs;
        }
        
       catch(Exception ex)
         {
           System.out.println("Error: "+ex);
         }
          
         return rs;
  }
  




  
  
  
   
   
   
   public  boolean updateTaskById(int id ,String title,String content,String statuse,String deadline)
{
     String sql = "UPDATE `task` SET `title` =\""+title+"\"  ,`content`=  \""+content+"\",`statues`= \""+statuse+"\""
             + ", `deadline` = STR_TO_DATE(\'"+deadline+"\', '%d-%m-%Y')   WHERE id = "+id  ;
       
   
   
        try {
              //System.out.println("\n "+sql+"\n");
           // set stmt to create statement
           stmt = conn.createStatement();
           // executeUpdate() function runs condition like insert, update, delete, drop etc
           // executeUpdate return 1 if true 0 if false
              if(stmt.executeUpdate(sql) == 1)
              return true ; //if row affected successfully return true
              
           
       } catch(Exception ex) {
           System.out.println("Error: "+ex);
       }
        return false; //else return false
    }     

   
   
     
  public boolean updateTaskById(int task_id ,String statuse)
  {
      String sql = "UPDATE `task` SET  `statues`= \""+statuse+"\"  WHERE id = "+task_id  ;
       
        try {
           // set stmt to create statement
           stmt = conn.createStatement();
           // executeUpdate() function runs condition like insert, update, delete, drop etc
           // executeUpdate return 1 if true 0 if false
              if(stmt.executeUpdate(sql) == 1)
              return true ; //if row affected successfully return true
              
           
       } catch(Exception ex) {
           System.out.println("Error: "+ex);    
       }
        return false; //else return false
  
  
  
  
  
  }

   
   
   
   
   
  
}







