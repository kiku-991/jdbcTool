package com.jdbctool.model.object;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogin {

    //ユーザID
    private Integer userId;
    //ユーザメール
    private String userMail;
    //パスワード
    private String userPassword;
    //生成時間
    private Timestamp createDate;
    //更新時間
    private Timestamp updateDate;
    //役割
    private String role;
    //状態
    private Integer status;


}
