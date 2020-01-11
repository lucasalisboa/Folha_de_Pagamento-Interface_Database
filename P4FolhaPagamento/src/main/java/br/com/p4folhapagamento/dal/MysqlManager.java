package br.com.p4folhapagamento.dal;

import java.sql.*;

public class MysqlManager {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/P4Database";
    
    public static Connection MysqlManager() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e) {
            System.out.println("Error:" + e);
            return null;
        }
    }  
}
