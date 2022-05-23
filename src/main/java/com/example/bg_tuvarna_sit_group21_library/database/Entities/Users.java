package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "approvaldate", nullable = false)
    private Integer approvaldate;

    @Column(name = "rating", nullable = false, length = 30)
    private String rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_statusid",referencedColumnName = "statusid", nullable = false)
    private Statuses statusStatusid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_usertypeid", referencedColumnName = "usertypeid", nullable = false)
    private Usertypes userUsertypeid;

    @OneToOne(mappedBy = "usersUserid")
    private Forms forms;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfos userInfos;

    @OneToMany(mappedBy = "usersUserid")
    private Set<Lendbooks> lendbooksSet;

    public Users(){

    }

    public Users(String username, String password, Integer approvaldate, String rating, Statuses statusStatusid, Usertypes userUsertypeid) {
        this.username = username;
        this.password = password;
        this.approvaldate = approvaldate;
        this.rating = rating;
        this.statusStatusid = statusStatusid;
        this.userUsertypeid = userUsertypeid;
    }

    public Users(Integer id, String username, String password, Integer approvaldate, String rating, Statuses statusStatusid, Usertypes userUsertypeid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.approvaldate = approvaldate;
        this.rating = rating;
        this.statusStatusid = statusStatusid;
        this.userUsertypeid = userUsertypeid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(Integer approvaldate) {
        this.approvaldate = approvaldate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Statuses getStatusStatusid() {
        return statusStatusid;
    }

    public void setStatusStatusid(Statuses statusStatusid) {
        this.statusStatusid = statusStatusid;
    }

    public Usertypes getUserUsertypeid() {
        return userUsertypeid;
    }

    public void setUserUsertypeid(Usertypes userUsertypeid) {
        this.userUsertypeid = userUsertypeid;
    }

    public Forms getForms() {
        return forms;
    }

    public void setForms(Forms forms) {
        this.forms = forms;
    }

    public UserInfos getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(UserInfos userInfos) {
        this.userInfos = userInfos;
    }

    public Set<Lendbooks> getLendbooksSet() {
        return lendbooksSet;
    }

    public void setLendbooksSet(Set<Lendbooks> lendbooksSet) {
        this.lendbooksSet = lendbooksSet;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", approvaldate=" + approvaldate +
                ", rating='" + rating + '\'' +
                ", statusStatusid=" + statusStatusid +
                ", userUsertypeid=" + userUsertypeid +
                ", forms=" + forms +
                ", userInfos=" + userInfos +
                ", lendbooksSet=" + lendbooksSet +
                '}';
    }
}