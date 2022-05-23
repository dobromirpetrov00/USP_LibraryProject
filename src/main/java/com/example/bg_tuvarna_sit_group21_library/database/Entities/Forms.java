package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "forms")
public class Forms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "formid", nullable = false)
    private Integer id;

    @Column(name = "creationdate", nullable = false)
    private Integer creationdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_userid",referencedColumnName = "userid", nullable = false)
    private Users usersUserid;

    public Forms() {

    }

    public Forms(Integer creationdate, Users usersUserid) {
        this.creationdate = creationdate;
        this.usersUserid = usersUserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Integer creationdate) {
        this.creationdate = creationdate;
    }

    public Users getUsersUserid() {
        return usersUserid;
    }

    public void setUsersUserid(Users usersUserid) {
        this.usersUserid = usersUserid;
    }

    @Override
    public String toString() {
        return "Forms{" +
                "id=" + id +
                ", creationdate=" + creationdate +
                ", usersUserid=" + usersUserid +
                '}';
    }
}