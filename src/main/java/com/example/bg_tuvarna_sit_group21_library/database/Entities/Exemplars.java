package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exemplars")
public class Exemplars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exemplarid", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "state_stateid", referencedColumnName = "stateid", nullable = false)
    private Bookstates stateStateid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookid", referencedColumnName = "bookid", nullable = false)
    private Books bookBookid;

    public Exemplars() {

    }

    public Exemplars(Books bookBookid){
        this.bookBookid=bookBookid;
    }

    public Exemplars(Books booksBookid, Bookstates stateStateid){
        this.bookBookid=booksBookid;
        this.stateStateid=stateStateid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bookstates getStateStateid() {
        return stateStateid;
    }

    public void setStateStateid(Bookstates stateStateid) {
        this.stateStateid = stateStateid;
    }

    public Books getBookBookid() {
        return bookBookid;
    }

    public void setBookBookid(Books bookBookid) {
        this.bookBookid = bookBookid;
    }

    @Override
    public String toString() {
        return "Exemplars{" +
                "id=" + id +
                ", stateStateid=" + stateStateid +
                ", bookBookid=" + bookBookid +
                '}';
    }
}