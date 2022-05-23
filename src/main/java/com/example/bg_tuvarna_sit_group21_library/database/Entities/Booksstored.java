package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "booksstored")
public class Booksstored {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid", nullable = false)
    private Integer id;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "available", nullable = false)
    private Integer available;

    @Column(name = "readingroom", nullable = false)
    private Integer readingroom;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookid", nullable = false)
    private Books books;

    public Booksstored() {

    }

    public Booksstored(Books books){
        this.books=books;
    }

    public Booksstored(Integer total, Integer available, Integer readingroom, Books books){
        this.total = total;
        this.available = available;
        this.readingroom = readingroom;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getReadingroom() {
        return readingroom;
    }

    public void setReadingroom(Integer readingroom) {
        this.readingroom = readingroom;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Booksstored{" +
                "id=" + id +
                ", total=" + total +
                ", available=" + available +
                ", readingroom=" + readingroom +
                ", books=" + books +
                '}';
    }
}