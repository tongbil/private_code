/*
 * Created by IntelliJ IDEA.
 * User: VULCAN
 * Date: 2020/2/11
 * Time: 18:00
 */
package com.sunny.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Userinfos implements Serializable{
    private int userid;
    private String username;
    private String password;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date brithday;
    private int userstate;

    public Userinfos(int userid, String username, String password, Date brithday, int userstate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.brithday = brithday;
        this.userstate = userstate;
    }

    @Override
    public String toString() {
        return "Userinfos{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", brithday=" + brithday +
                ", userstate=" + userstate +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getUserstate() {
        return userstate;
    }

    public void setUserstate(int userstate) {
        this.userstate = userstate;
    }
}