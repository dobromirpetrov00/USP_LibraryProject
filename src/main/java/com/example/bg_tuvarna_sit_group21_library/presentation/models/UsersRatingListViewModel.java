package com.example.bg_tuvarna_sit_group21_library.presentation.models;

public class UsersRatingListViewModel {
    private int id;
    private String name;
    private String rating;

    public UsersRatingListViewModel(int id, String name, String rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("UserID: %s | Name: %s | Rating: %s", id, name, rating);
    }
}
