package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu extends Container {
    private JButton Blogin;
    private JButton BsignUp;
    private JButton guest;
    private JButton exit;
    public MainMenu(){
        setSize(800,600);
        setLayout(null);

        Blogin=new JButton("Кіру");
        Blogin.setBounds(250,100,200,40);
        add(Blogin);

        Blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.login.setVisible(true);
            }
        });

        guest=new JButton("Қонақ ретінде кіру");
        guest.setBounds(250,160,200,40);
        add(guest);

        BsignUp=new JButton("Тіркелу");
        BsignUp.setBounds(250,220,200,40);
        add(BsignUp);

        BsignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.addUser.setVisible(true);
            }
        });

        exit=new JButton("Шығу");
        exit.setBounds(250,280,200,40);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
