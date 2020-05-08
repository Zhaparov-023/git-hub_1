package com.company;import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddUser extends Container {
    Connection connection;
    private JLabel lname;
    private JLabel lsurname;
    private JLabel email;
    private JLabel lpassword;
    private JLabel squest;
    private JLabel l_answer;
    private JTextField tname;
    private JTextField tsurname;
    private JTextField temail;
    private JPasswordField tpassword;
    private JTextField tanswer;
    private JButton bback;
    private JButton bsignUp;
    private JComboBox questions;
    private String [] question={"Сіздің сүйікті әншіңіз","Сіздің сүйікті актеріңіз","Сіздің туған жеріңіз"};
    public AddUser(){
        connection=Connect.ConnectDb();
        setSize(800, 600);
        setLayout(null);

        lname = new JLabel("Аты");
        lname.setBounds(220, 50, 40, 20);
        add(lname);

        tname = new JTextField();
        tname.setBounds(260, 50, 160, 20);
        add(tname);

        lsurname = new JLabel("Тегі");
        lsurname.setBounds(220, 90, 60, 20);
        add(lsurname);

        tsurname = new JTextField();
        tsurname.setBounds(260, 90, 160, 20);
        add(tsurname);

        email=new JLabel("Email");
        email.setBounds(200,130,40,20);
        add(email);

        temail=new JTextField();
        temail.setBounds(260,130,160,20);
        add(temail);

        lpassword = new JLabel("Құпия сөз");
        lpassword.setBounds(200, 170, 60, 20);
        add(lpassword);

        tpassword = new JPasswordField();
        tpassword.setBounds(260, 170, 160, 20);
        add(tpassword);

        squest=new JLabel("Құпия сұрақ");
        squest.setBounds(185,210,100,20);
        add(squest);

        questions=new JComboBox(question);
        questions.setBounds(260,210,160,20);
        add(questions);

        l_answer=new JLabel("Жауаб");
        l_answer.setBounds(200,250,100,20);
        add(l_answer);

        tanswer=new JTextField();
        tanswer.setBounds(260,250,160,20);
        add(tanswer);

        bsignUp=new JButton("Тіркелу");
        bsignUp.setBounds(220,290,200,40);
        add(bsignUp);

        bsignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(temail.getText()).equals("")&!(tname.getText()).equals("")&
                        !(tsurname.getText()).equals("")&!(tpassword.getText()).equals("")&
                        !((String)questions.getSelectedItem()).equals("")&!(tanswer.getText()).equals("")){
                    try {
                        String query = "insert into users(email,name,surname,password,sec_q,answer) values(?,?,?,?,?,?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, temail.getText());
                        preparedStatement.setString(2, tname.getText());
                        preparedStatement.setString(3, tsurname.getText());
                        preparedStatement.setString(4, tpassword.getText());
                        preparedStatement.setString(5, (String) questions.getSelectedItem());
                        preparedStatement.setString(6, tanswer.getText());
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Сіз тіркелдіңіз");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Барлық жолдарды толтыру қажет!");
                }
            }
        });

        bback=new JButton("Артқа");
        bback.setBounds(270,350,100,40);
        add(bback);

        bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.addUser.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}
