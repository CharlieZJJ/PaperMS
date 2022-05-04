package com.database.paperms.entity;


import com.database.paperms.entity.type.Permission;

import java.io.Serializable;

/**
 * ClassName: com.database.paperms.entity.User
 * Created by zjj
 * Date: 2022-05-04 22:38
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Permission userPermission;

    public User() {
    }

    public User(Integer userId, String userName, String userAccount, String userPassword, Permission userPermission) {
        this.userId = userId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userPermission = userPermission;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Permission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Permission userPermission) {
        this.userPermission = userPermission;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPermission=" + userPermission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!userId.equals(user.userId)) return false;
        if (!userName.equals(user.userName)) return false;
        if (!userAccount.equals(user.userAccount)) return false;
        if (!userPassword.equals(user.userPassword)) return false;
        return userPermission == user.userPermission;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userAccount.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + userPermission.hashCode();
        return result;
    }
}
