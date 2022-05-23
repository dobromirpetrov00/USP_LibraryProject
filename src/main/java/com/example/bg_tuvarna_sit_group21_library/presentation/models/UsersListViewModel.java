package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class UsersListViewModel {
    private int userid;
    private String username;
    private String password;
    private int approvaldate;
    private String rating;
    private int status_statusid;
    private int user_usertypeid;

    public UsersListViewModel(String username, String password){
        this.username=username;
        this.password=password;
    }

    public UsersListViewModel(int userid, String username, String password, int approvaldate, String rating, int status_statusid, int user_usertypeid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.approvaldate = approvaldate;
        this.rating = rating;
        this.status_statusid = status_statusid;
        this.user_usertypeid = user_usertypeid;
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

    public int getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(int approvaldate) {
        this.approvaldate = approvaldate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getStatus_statusid() {
        return status_statusid;
    }

    public void setStatus_statusid(int status_statusid) {
        this.status_statusid = status_statusid;
    }

    public int getUser_usertypeid() {
        return user_usertypeid;
    }

    public void setUser_usertypeid(int user_usertypeid) {
        this.user_usertypeid = user_usertypeid;
    }

    @Override
    public String toString() {
        return "AdminListViewModel{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", approvaldate=" + approvaldate +
                ", rating='" + rating + '\'' +
                ", status_statusid=" + status_statusid +
                ", user_usertypeid=" + user_usertypeid +
                '}';
    }
}
