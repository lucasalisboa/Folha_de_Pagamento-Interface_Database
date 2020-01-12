package br.com.p4folhapagamento.dal;

import java.sql.*;
import javax.inject.Named;

@Named
public class MysqlManager {
    private static Connection connection;
    private static final String pass = "";
    private static final String user = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/P4Database";
    
    public MysqlManager() {
        try {
            Class.forName(driver);
            MysqlManager.connection =  DriverManager.getConnection(url, user, pass);
        }
        catch(ClassNotFoundException | SQLException e) {
            MysqlManager.connection = null;
            System.out.println("Error:" + e);
        }
    } 
    
    public Connection getConnection() {
        return MysqlManager.connection;
    }
}
