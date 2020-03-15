package com.example.myexperiments.rxJava;

public class User {
    private String name;
    private String sex;
    private String address;

    public User() {

    }

    public User(String name, String sex, String address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
