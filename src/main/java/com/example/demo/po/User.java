package com.example.demo.po;

/**
 * @author: crj
 * @date: 2018年8月21日 上午10:42:13
 */
public class User {
    private Long id;//实体类的唯一标志
    private String username;//用户名字
    private String password;//密码
    private String name;//名字

    public User(Long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(){
        //无参的默认的构造函数
    }


}
