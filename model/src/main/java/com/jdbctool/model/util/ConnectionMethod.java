/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.model.util;

import com.jdbctool.model.ConnectionInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ConnectionMethod {

    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rset;
    public static String jdbcUrl;

    public static List<String> dataNameList = new ArrayList<>();

//    public static void main(String... args) {
//        Statement xx = getConn("kiku", "postgres", "postgres");
//        if (xx != null) {
//            System.out.println("sssssss");
//        } else {
//            System.out.println("aaaa");
//        }
//    }
    /**
     * データベース接続
     *
     * @param databaseName
     * @param userName
     * @param pwd
     * @return stmt
     */
    public static Statement getConn(String databaseName, String userName, String pwd) {

        //DataBaseInfo database = new DataBaseInfo();
        //ドライバー
        String driver = ConmentMessage.DRIVER;
        //データベース名
        ConnectionInfo info = new ConnectionInfo();

        info.setDatabaseName(databaseName);
        //ユーザ名
        info.setUserName(userName);
        //パスワード
        info.setPassword(pwd);
        //データベース別名
        String databaseAlias = ConmentMessage.LOCALHOST + databaseName;
        info.setDatabaseAlias(databaseAlias);

        //データベース別名List
        dataNameList.add(databaseAlias);
        info.setDatabaseAliasList(dataNameList);
        //dbInfo.add(database);

        jdbcUrl = ConmentMessage.JDBCURL + databaseName;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, pwd);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectionMethod.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stmt;

    }

    /**
     * クローズデータベース
     *
     * @throws SQLException
     */
    public static void closeDBcon() throws SQLException {
        if (conn != null) {
            stmt.close();
            conn.close();
        }
    }

    /**
     * ログイン
     *
     * @param databaseName
     * @param username
     * @param pwd
     * @return
     */
    public static Statement getDBConn(String databaseName, String username, String pwd) {
        //ドライバー
        String driver = ConmentMessage.DRIVER;
        // String url = "jdbc:postgresql://" + sname + ":" + portNum + "/" + dbname;
        jdbcUrl = ConmentMessage.JDBCURL + databaseName;

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(jdbcUrl, username, pwd);
            stmt = conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMethod.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionMethod.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return stmt;

    }

    /**
     * すべてのテーブル名を取得
     *
     * @param databaseName
     * @param username
     * @param pwd
     * @return tableList
     */
    public static ArrayList<String> getAllTableList(String databaseName, String username, String pwd) {

        ResultSet rset;
        ArrayList<String> tableList = new ArrayList<>();
        //すべてのテーブルを取得sql
        String sql = "select\r\n"
                + "    tablename \r\n"
                + "from\r\n"
                + "    pg_tables \r\n"
                + "where\r\n"
                + "    schemaname = 'public'";
        try {
            //PostgreSQLへ接続
            getDBConn(databaseName, username, pwd);
            rset = stmt.executeQuery(sql);
            //SELECT結果の受け取り
            while (rset.next()) {
                String col = rset.getString(1);
                tableList.add(col);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMethod.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return tableList;

    }

    /**
     * データベースの値を取得
     *
     * @param databaseName
     * @param userName
     * @param pwd
     * @param sql
     */
    public static List<List<Object>> getResultValue(String databaseName, String userName, String pwd, String sql) {

        List<List<Object>> resultList = new ArrayList<>();

        try {
            rset = getConn(databaseName, userName, pwd).executeQuery(sql);
            ResultSetMetaData rsmd = rset.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rset.next()) {
                List<Object> newList = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    String value = rset.getString(i);
                    newList.add(value);

                }
                resultList.add(newList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultList;
    }

    /**
     * カラム名を取得
     *
     * @param databaseName
     * @param userName
     * @param pwd
     * @param sql
     * @return
     */
    public static List<String> ColumnName(String databaseName, String userName, String pwd, String sql) {

        List<String> columnNames = new ArrayList<String>();
        try {

            rset = getConn(databaseName, userName, pwd).executeQuery(sql);

            // Execute SQL query
            stmt = conn.createStatement();
            if (rset != null) {
                ResultSetMetaData columns = rset.getMetaData();
                int i = 0;
                while (i < columns.getColumnCount()) {
                    i++;
                    String conName = columns.getColumnName(i);
                    columnNames.add(conName);
                }

            }
        } catch (Exception e) {
            Logger.getLogger(ConnectionMethod.class.getName()).log(Level.SEVERE, null, e);
        }

        return columnNames;

    }

}
