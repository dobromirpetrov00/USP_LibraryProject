package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class BooksInfoListViewModel {
    private int bookid, year, total, available, readingRoom;
    private String bookname, author, genre, isArchived, state;

    public BooksInfoListViewModel(int bookid, int year, int total, int available, int readingRoom, String bookname, String author, String genre, String isArchived, String state) {
        this.bookid = bookid;
        this.year = year;
        this.total = total;
        this.available = available;
        this.readingRoom = readingRoom;
        this.bookname = bookname;
        this.author = author;
        this.genre = genre;
        this.isArchived = isArchived;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("BookID: %s | Bookname: %s | Author: %s | Genre: %s | Year: %s | Total: %s | Available: %s | Reading Room: %s | State: %s | Needs to be archived: %s",
                bookid,bookname,author,genre,year,total,available,readingRoom,state,isArchived);
    }
}
