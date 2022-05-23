package com.example.bg_tuvarna_sit_group21_library.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService=BookService.getInstance();
    }

    @Test
    void getAllBookInfo() {
        assertNotNull(bookService.getAllBookInfo());
    }

    // DONE
    @Test
    void getLendBooksInfos() {
        assertNotNull(bookService.getLendBooksInfos());
    }
}