/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagment;
import java.awt.Color;
import javax.swing.*;
import javafx.scene.layout.Pane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author root
 */




public class LoginUI extends javax.swing.JFrame{

    
    JFrame Frame1;
    JLabel Label1;
    JLabel Label2;
   // JLabel Label3;
    JTextField Textfield1;
    JTextField Textfield2;
    JButton Button1;
    JButton Button2;
    //ImageIcon image;
   Member person_obj = new Member();
   String Username ,Password;
    

    public LoginUI() {
        //Frame
        this.setLocationRelativeTo(null);
        Frame1 = new JFrame("Login page");
        Frame1.setLayout(null);
        Frame1.setSize(500, 500);
        Frame1.getContentPane().setBackground(Color.darkGray);
        
        Label1 = new JLabel("username");
        Frame1.add(Label1);
        Label1.setForeground(Color.white);
        Label1.setBounds(70,30, 202, 200);
        //textfield
        Textfield1 = new JTextField(10);
        Frame1.add(Textfield1);
       // Textfield1.setText("username");
        Textfield1.setBounds(140, 120, 100, 20);

        //label2
        Label2 = new JLabel("password");
        Frame1.add(Label2);
        Label2.setForeground(Color.white);
        Label2.setVerticalAlignment(JLabel.CENTER);
        Label2.setBounds(70, 60, 202, 200);
        //textfield2
        Textfield2 = new JPasswordField(10);
        Frame1.add(Textfield2);
       // Textfield2.setText("pass");
        Textfield2.setBounds(140, 150, 100, 20);
        //Button1
        Button1 = new JButton("log in");
        Frame1.add(Button1);
        Button1.setBounds(80, 180, 100, 20);
        Button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Username  = (Textfield1.getText());
               Password = (Textfield2.getText());
                
               GeneralFunctions gen_obj = new GeneralFunctions();
                person_obj.id = gen_obj.loginMember(Username, Password);
                if (person_obj.id != 0)
                {
                   String role = gen_obj.checkRole(person_obj.id);
                            if(role.equals("leader")){
                                LeaderViewTaskUI LUIObject = new LeaderViewTaskUI();
                                LUIObject.setLeaderId(person_obj.id);
                                LUIObject.setVisible(true);      
                                Frame1.setVisible(false); }
                            else {
                                 MemberViewTaskUI MUIObject = new MemberViewTaskUI();
                                MUIObject.setMemberId(person_obj.id);
                                MUIObject.setVisible(true);  
                                Frame1.setVisible(false);}
                }
                else
                { 
                    JOptionPane.showMessageDialog(Frame1, "Wrong UserName OR Password");
                }
                    
            }
        });
        //Button2
        Button2=new JButton("exit");
        Frame1.add(Button2);
        Button2.setBounds(200, 180, 100, 20);
        Button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               int a=JOptionPane.showConfirmDialog(null, "do you want to exit the application","Select",JOptionPane.YES_NO_OPTION);
            if(a==0)
            {
                System.exit(0);
            }
            }
        });
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame1.setVisible(true);
    }

}