package com.ponloo.extend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/17.
 */
@Entity
@Table(name = "t_s_user")
public class T_S_User extends BaseModel{
    /*用户名*/
    @Column(name = "username")
    private String username;
    /*用户密码*/
    @Column(name = "password")
    private String password;

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
}
