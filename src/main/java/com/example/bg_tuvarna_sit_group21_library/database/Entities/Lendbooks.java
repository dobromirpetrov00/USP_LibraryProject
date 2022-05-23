package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lendbooks")
public class Lendbooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendbooksid", nullable = false)
    private Integer id;

    @Column(name = "lenddate", nullable = false)
    private Integer lenddate;

    @OneToOne(mappedBy = "lendLendbooksid")
    private Lendinfos lendinfos;

    @ManyToOne
    @JoinColumn(name = "user_userid", nullable = false)
    private Users usersUserid;

    /*@ManyToOne
    @JoinColumn(name = "user_userid",referencedColumnName = "userid", nullable = false)
    private Users usersUserid;*/

    public Lendbooks() {

    }

    public Lendbooks(Users usersUserid, Integer lenddate) {
        this.lenddate = lenddate;
        this.usersUserid = usersUserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLenddate() {
        return lenddate;
    }

    public void setLenddate(Integer lenddate) {
        this.lenddate = lenddate;
    }

    public Lendinfos getLendinfos() {
        return lendinfos;
    }

    public void setLendinfos(Lendinfos lendinfos) {
        this.lendinfos = lendinfos;
    }

    public Users getUsersUserid() {
        return usersUserid;
    }

    public void setUsersUserid(Users usersUserid) {
        this.usersUserid = usersUserid;
    }

    @Override
    public String toString() {
        return "Lendbooks{" +
                "id=" + id +
                ", lenddate=" + lenddate +
                ", lendinfos=" + lendinfos +
                ", usersUserid=" + usersUserid +
                '}';
    }
}