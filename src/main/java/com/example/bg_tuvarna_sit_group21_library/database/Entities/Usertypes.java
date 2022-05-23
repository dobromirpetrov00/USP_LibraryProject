package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usertypes")
public class Usertypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usertypeid", nullable = false)
    private Integer id;

    @Column(name = "usertype", nullable = false, length = 30)
    private String usertype;

    @OneToMany(mappedBy = "userUsertypeid")
    private Set<Users> usersSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }
}