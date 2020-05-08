package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends Container{
    Connection connection;
    private JLabel name;
    private JTextField t_name;
    private JLabel surname;
    private JTextField t_surname;
    private JLabel password;
    private JPasswordField t_password;
    private JButton Bback;
    private JButton lbcontinue;
    private JButton forgot;
    public Login(){
        connection=Connect.ConnectDb();
        setSize(800,600);
        setLayout(null);

        name = new JLabel("Аты");
        name.setBounds(220, 50, 40, 20);
        add(name);

        t_name = new JTextField();
        t_name.setBounds(260, 50, 160, 20);
        add(t_name);

        surname = new JLabel("Тегі");
        surname.setBounds(220, 90, 60, 20);
        add(surname);

        t_surname = new JTextField();
        t_surname.setBounds(260, 90, 160, 20);
        add(t_surname);

        password = new JLabel("Құпия сөз");
        password.setBounds(200, 130, 60, 20);
        add(password);

        t_password = new JPasswordField();
        t_password.setBounds(260, 130, 160, 20);
        add(t_password);

        Bback=new JButton("Артқа");
        Bback.setBounds(270,320,100,40);
        add(Bback);

        Bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.login.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });

        lbcontinue=new JButton("Жалғастыру");
        lbcontinue.setBounds(220,200,200,40);
        add(lbcontinue);

        lbcontinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(t_name.getText()).equals("")&!(t_surname.getText()).equals("")&!(t_password.getText()).equals("")) {
                    try {
                        String query = "select * from users where name=? and surname=? and password=?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, t_name.getText());
                        preparedStatement.setString(2, t_surname.getText());
                        preparedStatement.setString(3, t_password.getText());
                        ResultSet resultset = preparedStatement.executeQuery();
                        if (resultset.next()) {
                            resultset.close();
                            preparedStatement.close();
                            Main.frame.login.setVisible(false);
                            Main.frame.test.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Атыңыз,тегіңіз немесе құпия сөз қате терілген!");
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
        forgot=new JButton("Құпия сөз?");
        forgot.setBounds(245,260,150,40);
        add(forgot);

        forgot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.login.setVisible(false);
                Main.frame.forgot.setVisible(true);
            }
        });
    }
}
