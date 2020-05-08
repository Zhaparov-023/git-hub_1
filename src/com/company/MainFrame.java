package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame{
    public static MainMenu mainMenu;
    public static AddUser addUser;
    public static Login login;
    public static Test test;
    public static Forgot_pass forgot;
    public static ChangePass changePass;
   public MainFrame(){
       setSize(800,600);
       setTitle("Қазақстан тарихынан тест");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);

       mainMenu=new MainMenu();
       mainMenu.setLocation(0,0);
       add(mainMenu);

       addUser=new AddUser();
       addUser.setLocation(0,0);
       addUser.setVisible(false);
       add(addUser);

       login=new Login();
       login.setLocation(0,0);
       login.setVisible(false);
       add(login);

       test=new Test();
       test.setLocation(0,0);
       test.setVisible(false);
       add(test);

       forgot=new Forgot_pass();
       forgot.setLocation(0,0);
       forgot.setVisible(false);
       add(forgot);

       changePass=new ChangePass();
       changePass.setLocation(0,0);
       changePass.setVisible(false);
       add(changePass);
    }
}
