/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.lib.user;

import java.io.File;

/**
 *
 * @author sev_user
 */
public class User {

    private int id;
    private String userName;
    private String pass;
    private String fullName;
    private String email;
    private File avatar;
    private String birthday;
    private String lastTimeLogin;
    private SettingUser settingUser;

    public User(int id, String userName, String pass, String fullName, String email, File avatar, String birthday, SettingUser settingUser, String lastTimeLogin) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.fullName = fullName;
        this.email = email;
        this.avatar = avatar;
        this.birthday = birthday;
        this.settingUser = settingUser;
        this.lastTimeLogin = lastTimeLogin;
    }

    public User(String userName, String pass, String fullName, String email, File avatar, String birthday, SettingUser settingUser, String lastTimeLogin) {
        this(0, userName, pass, fullName, email, avatar, birthday, settingUser, lastTimeLogin);
    }

    public User(String userName, String pass, String fullName, String email, String birthday) {
        this(userName, pass, fullName, email, null, birthday, null, "");
    }

    public User(String userName, String pass) {
        this(userName, pass, "", "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public File getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastTimeLogin() {
        return lastTimeLogin;
    }

    public void setLastTimeLogin(String lastTimeLogin) {
        this.lastTimeLogin = lastTimeLogin;
    }

    public SettingUser getSettingUser() {
        return settingUser;
    }

    public void setSettingUser(SettingUser settingUser) {
        this.settingUser = settingUser;
    }
    
    

    @Override
    public String toString() {
        return "id: " + id + " userName: " + userName + " pass: " + pass + " fullName: " + fullName + " avatar: " + avatar + " birthday: " + birthday + " lastTimeLogin: " + lastTimeLogin;
    }
}
