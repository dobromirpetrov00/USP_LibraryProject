package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "books")
public class Books implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid", nullable = false)
    private Integer id;

    @Column(name = "bookname", nullable = false, length = 60)
    private String bookname;

    @Column(name = "author", nullable = false, length = 60)
    private String author;

    @Column(name = "genre", nullable = false, length = 30)
    private String genre;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "isarchived", nullable = false, length = 30)
    private String isarchived;

    @OneToOne(mappedBy = "bookBookid")
    private Exemplars exemplars;

    @OneToOne(mappedBy = "books", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Booksstored booksstored;

    @OneToMany(mappedBy = "bookBookid")
    private Set<Lendinfos> lendinfosSet;

    public Books(){

    }

    public Books(String bookname, String author, String genre, Integer year, String isarchived){
        this.bookname = bookname;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.isarchived = isarchived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getIsarchived() {
        return isarchived;
    }

    public void setIsarchived(String isarchived) {
        this.isarchived = isarchived;
    }

    public Exemplars getExemplars() {
        return exemplars;
    }

    public void setExemplars(Exemplars exemplars) {
        this.exemplars = exemplars;
    }

    public Booksstored getBooksstored() {
        return booksstored;
    }

    public void setBooksstored(Booksstored booksstored) {
        this.booksstored = booksstored;
    }

    public Set<Lendinfos> getLendinfosSet() {
        return lendinfosSet;
    }

    public void setLendinfosSet(Set<Lendinfos> lendinfosSet) {
        this.lendinfosSet = lendinfosSet;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", isarchived='" + isarchived + '\'' +
                ", exemplars=" + exemplars +
                ", booksstored=" + booksstored +
                ", lendinfosSet=" + lendinfosSet +
                '}';
    }
}