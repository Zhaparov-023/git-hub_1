package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ChangePass extends Container {
    Connection connection;
    private JLabel l_name;
    private JLabel email;
    private JLabel pass;
    private JLabel n_pass;

    private JTextField t_name;
    private JTextField t_email;
    private JPasswordField t_pass;
    private JPasswordField new_pass;

    private JButton change_pass;
    private JButton back;
    public ChangePass(){

        connection=Connect.ConnectDb();

        setSize(800,600);
        setLayout(null);

        l_name=new JLabel("Аты");
        l_name.setBounds(220, 50, 40, 20);
        add(l_name);

        t_name = new JTextField();
        t_name.setBounds(260, 50, 160, 20);
        add(t_name);

        email = new JLabel("Email");
        email.setBounds(220, 90, 60, 20);
        add(email);

        t_email = new JTextField();
        t_email.setBounds(260, 90, 160, 20);
        add(t_email);

        pass= new JLabel("Құпия сөз");
        pass.setBounds(200, 130, 60, 20);
        add(pass);

        t_pass = new JPasswordField();
        t_pass.setBounds(260, 130, 160, 20);
        add(t_pass);

        n_pass=new JLabel("Жаңа құпия сөз");
        n_pass.setBounds(165, 170, 100, 20);
        add(n_pass);

        new_pass=new JPasswordField();
        new_pass.setBounds(260, 170, 160, 20);
        add(new_pass);

        change_pass=new JButton("Құпия сөзді өзгерту");
        change_pass.setBounds(240,220,170,40);
        add(change_pass);

        change_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(t_name.getText()).equals("")&!(t_email.getText()).equals("")&
                        !(t_pass.getText()).equals("")&!(new_pass.getText()).equals("")) {
                    try {

                        String query = "select * from users where name=? and email=? and password=?";
                        PreparedStatement preparedStatement1=connection.prepareStatement(query);
                        preparedStatement1.setString(1,t_name.getText());
                        preparedStatement1.setString(2,t_email.getText());
                        preparedStatement1.setString(3,t_pass.getText());
                        ResultSet resultSet=preparedStatement1.executeQuery();
                        if(resultSet.next()){
                            String user_name=t_name.getText();
                            String user_email=t_email.getText();
                            String query2="update users set password=? where name='"+user_name+"'" +
                                    " and email='"+user_email+"'";
                            PreparedStatement preparedStatement=connection.prepareStatement(query2);
                            preparedStatement.setString(1,new_pass.getText());
                            preparedStatement.executeUpdate();
                            resultSet.close();
                            preparedStatement1.close();
                            JOptionPane.showMessageDialog(null,"Құпия сөз өзгертілді.");
                            t_name.setText("");
                            t_email.setText("");
                            t_pass.setText("");
                            new_pass.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Мұндай қолданушы жоқ.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Барлық жолдарды толтыру қажет!");
                }
            }
        });

        back=new JButton("Артқа");
        back.setBounds(270,300,100,40);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t_name.setText("");
                t_email.setText("");
                t_pass.setText("");
                new_pass.setText("");
                Main.frame.changePass.setVisible(false);
                Main.frame.forgot.setVisible(true);
            }
        });

    }
}
