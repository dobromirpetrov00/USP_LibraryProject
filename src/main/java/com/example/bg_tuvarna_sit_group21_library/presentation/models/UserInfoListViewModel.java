package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class UserInfoListViewModel {
    private int userid;
    private String username;
    private String password;
    private int approvalDate;
    private String usertype;
    private String name;
    private String phone;
    private String email;

    public UserInfoListViewModel(int userid, String username, String password, String name, String phone, String email, String usertype, int approvalDate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.usertype = usertype;
        this.approvalDate = approvalDate;
    }

    @Override
    public String toString() {
        return String.format("UserID: %s | Username: %s | Password: %s | Name: %s | Phone: %s | Email: %s | Usertype: %s | Approval Date: %s",
                userid,username,password,name,phone,email,usertype,approvalDate);
    }
}
