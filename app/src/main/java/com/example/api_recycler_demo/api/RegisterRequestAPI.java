package com.example.api_recycler_demo.api;

public class RegisterRequestAPI {
    String name;
    String mobile;
    String email;
    String password;
    String gender;

    public RegisterRequestAPI(String name, String mobile, String gender, String email, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
}
