package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class BooksNeedToBeArchivedListViewModel {
    private Integer bookid;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public BooksNeedToBeArchivedListViewModel(Integer bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "BooksNeedToBeArchivedListViewModel{" +
                "bookid=" + bookid +
                '}';
    }
}
