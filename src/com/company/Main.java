package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Main {
    public static MainFrame frame;
    public static ArrayList<User>users=new ArrayList<>();
    public static ArrayList<String>questions=new ArrayList<>();
    public static ArrayList<String>answers=new ArrayList<>();
    public static void main(String[] args) {
        frame=new MainFrame();
       frame.setVisible(true);
    }
}
