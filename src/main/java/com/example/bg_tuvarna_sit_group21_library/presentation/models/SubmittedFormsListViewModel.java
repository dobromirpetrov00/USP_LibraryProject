package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class SubmittedFormsListViewModel {
    private int formid;
    private int creationDate;
    private int userid;
    private String status;

    public SubmittedFormsListViewModel(int formid, int creationDate, int userid, String status) {
        this.formid = formid;
        this.creationDate = creationDate;
        this.userid = userid;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("FormID: %s | Creation Date: %s | UserID: %s |  Status: %s", formid, creationDate, userid, status);
    }
}
