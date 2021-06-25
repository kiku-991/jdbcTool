/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author
 */
@Setter
@Getter
public class ConnectionInfo {

    // ユーザ名
    public String userName;
    //パスワード
    public String password;
    //データベース名
    public String databaseName;
    //ポート番号
    public String portNunmber;
    //サーバ名
    public String server;
    //url
    public String url;
    //データベース別名
    public String databaseAlias;
    //データベース別名List
    public List<String> databaseAliasList;

}
