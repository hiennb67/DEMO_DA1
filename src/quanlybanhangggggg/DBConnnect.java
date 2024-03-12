/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangggggg;

import java.sql.*;

/**
 *
 * @author hiep nguyen
 */
public class DBConnnect {

    static String url = "jdbc:sqlserver://;serverName=NGUYENHIEP;databaseName=BanHangQuanAo";
    static String username = "sa";
    static String password = "hien";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
