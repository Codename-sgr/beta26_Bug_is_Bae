package com.bugisbae.bloodhive;

public class user {
    String user_id;
    String user_name;
    String email;
    String mobile;

    String address;

    public user(String user_id, String user_name, String email) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;

    }

    public user(String user_id, String user_name, String email, String mobile, String address) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
