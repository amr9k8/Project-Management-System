/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagment;


/**
 *
 * @author mac
 */
public class Leader extends Person {
    



   
//ALL OF NEXT FUNCTIONS RETURN TRUE OR FALSE
   
public boolean addTask(String title,String content,String statuse,String deadline )
{
     String sql = "INSERT INTO `task`(`title`, `content`, `statues`, `deadline`) "
             + "VALUES (\""+title+"\",\""+content+"\",\""+statuse+"\",STR_TO_DATE(\'"+deadline+"\' , '%d-%m-%Y') )  ";
     
           //System.out.println(sql);
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
    

public boolean removeTaskById(int id)
{
     String sql = "DELETE FROM  `task` WHERE `id` = "+id;
        try 
        {
           // set stmt to create statement
           stmt = conn.createStatement();
           // executeUpdate() function runs condition like insert, update, delete, drop etc
           // executeUpdate return 1 if true 0 if false
          if(stmt.executeUpdate(sql) == 1)
              return true ; //if row affected successfully return true
          
         
           
       } 
        catch(Exception ex) 
       {
           System.out.println("Error: "+ex);
       }
         return false; //else return false
    }       

public boolean assignTask(int task_id,int member_id )
{
     String sql = "INSERT INTO `task_assignment`(`task_id`, `member_id`) "
             + "VALUES ("+task_id+","+member_id+")  ";
   
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
    
public boolean unAssignTask(int Task_id,int member_id)
{
     String sql = "DELETE FROM  `task_assignment` WHERE `task_id`= "+Task_id+" AND`member_id`= "+member_id+" ";
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









//HERE YOU CAN LOOP THROUGHT ALL RESULT RETURNED FROM DB 

//ResultSet rs = taskobj.getTasksById(4);    
//    try{
//    while(rs.next())
//    {
//            int member_id=rs.getInt("member_id");
//            int team_id = rs.getInt("team_id");
//            int task_id = rs.getInt("task_id");
//            String member_name = rs.getString("name");
//            String member_pass = rs.getString("password");
//            String member_role = rs.getString("role");
//            String task_title = rs.getString("task_title");
//            String task_content= rs.getString("task_content");
//            String task_statues = rs.getString("task_statues");
//            String task_date = rs.getString("task_date");
//            String task_deadline = rs.getString("task_deadline");     
//    }
//    }
//    catch(Exception e)
//    {   
//        System.out.println("Error:"+e);
//    }
