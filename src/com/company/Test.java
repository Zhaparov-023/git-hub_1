package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Test extends Container{
    private JLabel quest;
    private JLabel lb_answer;
    private JTextField answer;
    private JLabel quest2;
    private JLabel lb2_answer;
    private JTextField answer2;
    private JLabel comp;
    private JLabel comp2;
    private JButton check;
    public Test(){
        setSize(800,600);
        setLayout(null);
       try{
            BufferedReader reader=new BufferedReader(new FileReader("Жауабы.txt"));
           BufferedReader read=new BufferedReader(new FileReader("Сұрактары.txt"));
           String empty=null;
            String tempt=null;
           while((tempt=reader.readLine())!=null){
               Main.questions.add(tempt);
           }
           while((empty=read.readLine())!=null){
               Main.answers.add(empty);
           }
        }catch (Exception e) {
           e.printStackTrace();
       }
        quest=new JLabel("1."+Main.answers.get(0));
        quest.setBounds(80,10,500,20);
        add(quest);

        answer=new JTextField();
        answer.setBounds(120,40,200,20);
        add(answer);

        lb_answer=new JLabel("Жауабы");
        lb_answer.setBounds(70,40,50,20);
        add(lb_answer);

        quest2=new JLabel("2."+Main.answers.get(1));
        quest2.setBounds(80,80,500,20);
        add(quest2);

        lb2_answer=new JLabel("Жауабы");
        lb2_answer.setBounds(70,110,50,20);
        add(lb2_answer);
        answer2=new JTextField();
        answer2.setBounds(120,110,200,20);
        add(answer2);

        check=new JButton("Тексеру");
        check.setBounds(100,180,100,60);
        add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String answer1=answer.getText().toUpperCase();
                String answer2=Main.answers.get(0).toUpperCase();
                if(answer1.equals(answer2)){
                  JOptionPane.showMessageDialog(null,"Your answer is right.");
                }else{
                   JOptionPane.showMessageDialog(null,"Your answer isn't right.");
                }
            }
        });
    }
}
