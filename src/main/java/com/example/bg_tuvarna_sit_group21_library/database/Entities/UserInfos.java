package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "user_infos")
public class UserInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userid", nullable = false)
    private Users users;

    public UserInfos(){

    }

    public UserInfos(String  name, String phone, String email, Users users) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.users=users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserInfos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", users=" + users +
                '}';
    }
}