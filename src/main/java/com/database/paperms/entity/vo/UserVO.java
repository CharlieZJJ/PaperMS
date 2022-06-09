package com.database.paperms.entity.vo;

import java.io.Serializable;

public class UserVO implements Serializable {

    private String userAccount;

    private String userName;

    public UserVO(String userAccount, String userName) {
        this.userAccount = userAccount;
        this.userName = userName;
    }

    public UserVO() {
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
