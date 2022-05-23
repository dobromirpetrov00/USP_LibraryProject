package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class UserInfoListViewModelNoImportant {
    private int userid;
    private int approvalDate;
    private String usertype;
    private String name;
    private String phone;
    private String email;

    public UserInfoListViewModelNoImportant(int userid, String name, String phone, String email, String usertype, int approvalDate) {
        this.userid = userid;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.usertype = usertype;
        this.approvalDate = approvalDate;
    }

    @Override
    public String toString() {
        return String.format("UserID: %s | Name: %s | Phone: %s | Email: %s | Usertype: %s | Approval Date: %s",
                userid,name,phone,email,usertype,approvalDate);
    }
}
