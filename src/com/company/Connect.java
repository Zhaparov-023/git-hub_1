package com.company;
import java.sql.*;
public class Connect {
    private static Connection connect=null;
    private static Statement statement=null;
    private static ResultSet resultSet=null;
    private static String url="jdbc:mysql://localhost/final?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user="root";
    private static String pass="";
public static Connection ConnectDb(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection(url,user,pass);
        return connect;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}
