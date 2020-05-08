package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Forgot_pass extends Container {
    Connection connection;
    private JLabel lname;
    private JLabel lsurname;
    private JLabel lemail;
    private JLabel quest;
    private JLabel l_answer;
    private JLabel l_pass;

    private JTextField tname;
    private JTextField tsurname;
    private JTextField t_email;
    private JTextField t_quest;
    private JTextField t_answer;
    private JTextField t_pass;

    private JButton back;
    private JButton search;
    private JButton check;
    private JButton change_pass;
    public Forgot_pass(){

        connection=Connect.ConnectDb();

        setSize(800,600);
        setLayout(null);

        lname=new JLabel("Аты");
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

        lemail = new JLabel("Email");
        lemail.setBounds(200, 130, 60, 20);
        add(lemail);

        t_email = new JTextField();
        t_email.setBounds(260, 130, 160, 20);
        add(t_email);

        quest=new JLabel("Сұрақ");
        quest.setBounds(200, 170, 60, 20);
        add(quest);

        t_quest=new JTextField();
        t_quest.setBounds(260, 170, 160, 20);
        add(t_quest);

        l_answer=new JLabel("Жауаб");
        l_answer.setBounds(200,210,60,20);
        add(l_answer);

        t_answer=new JTextField();
        t_answer.setBounds(260,210,160,20);
        add(t_answer);

        l_pass=new JLabel("Құпия сөзіңіз");
        l_pass.setBounds(170,250,80,20);
        add(l_pass);

        t_pass=new JTextField();
        t_pass.setBounds(260,250,160,20);
        add(t_pass);

        back=new JButton("Артқа");
        back.setBounds(270,360,100,40);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tname.setText("");
                tsurname.setText("");
                t_email.setText("");
                t_quest.setText("");
                t_answer.setText("");
                t_pass.setText("");
                Main.frame.forgot.setVisible(false);
                Main.frame.login.setVisible(true);
            }
        });

        search=new JButton("Іздеу");
        search.setBounds(440,60,100,40);
        add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!(tname.getText()).equals("") & !(tsurname.getText()).equals("") & !(t_email.getText()).equals("")) {
                    try {
                        String user_name = tname.getText();
                        String user_surname = tsurname.getText();
                        String user_email = t_email.getText();

                        String query = "select * from users where name='" + user_name + "' and surname='" + user_surname + "' and email='" + user_email + "'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
                        if (resultSet.next()) {
                            JOptionPane.showMessageDialog(null, "Мұндай қолданушы бар");
                            String question = resultSet.getString("sec_q");
                            t_quest.setText(question);
                            resultSet.close();
                            statement.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Мұндай қолданушы жоқ");
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

        check=new JButton("Тексеру");
        check.setBounds(440,170,100,40);
        add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String ans = t_answer.getText();
                    String query = "select * from users where answer='" + ans + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    if(resultSet.next()){
                        String answ=resultSet.getString("password");
                        t_pass.setText(answ);
                        resultSet.close();
                        statement.close();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Сіздің жауабыңыз қате!");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        change_pass=new JButton("Құпия сөзді өзгерту");
        change_pass.setBounds(240,300,180,40);
        add(change_pass) ;

        change_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.forgot.setVisible(false);
                Main.frame.changePass.setVisible(true);
            }
        });
    }

}
