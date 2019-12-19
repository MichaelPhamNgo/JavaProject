/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author micha
 */
public class DBConnect {
    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qlsv", "user1", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
 
    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        System.out.println(conn.toString());
        conn.close();
    }
}
