package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class LendBooksInfoListViewModel {
    private int lendbooksid, userid, lenddate;

    public LendBooksInfoListViewModel(int lendbooksid, int userid, int lenddate) {
        this.lendbooksid = lendbooksid;
        this.userid = userid;
        this.lenddate = lenddate;
    }

    @Override
    public String toString() {
        return String.format("LendbookID: %s | UserID: %s | Lend Date: %s",lendbooksid,userid,lenddate);
    }
}
