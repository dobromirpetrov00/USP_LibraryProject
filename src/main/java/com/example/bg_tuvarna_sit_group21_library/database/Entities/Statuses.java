package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "statuses")
public class Statuses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statusid", nullable = false)
    private Integer id;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @OneToMany(mappedBy = "statusStatusid")
    private Set<Users> usersSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

//    @Override
//    public String toString() {
//        return "Statuses{" +
//                "id=" + id +
//                ", status='" + status + '\'' +
//                ", usersSet=" + usersSet +
//                '}';
//    }
}