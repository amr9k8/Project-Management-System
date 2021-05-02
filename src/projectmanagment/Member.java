/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagment;

import java.sql.ResultSet;

/**
 *
 * @author mac
 */
public class Member extends Person {
    

    
    
 //return true if task assigned to person
   public boolean checkIfTaskIsMine(int member_id ,int task_id)
   {    
       boolean found = false;
       
       ResultSet rs = this.getPersonTasksById(member_id);
       
       
        try {
            while(rs.next())
                
            { 
                if (rs.getInt("task_id") == task_id) 
                   found = true;
               
            }
             
              return found;
           
       } catch(Exception ex) {
           System.out.println("Error: "+ex);
           return found;
       }
     
   }
   
}
