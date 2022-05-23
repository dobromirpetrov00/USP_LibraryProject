package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    private boolean VarAlreadySetToArchiveLater, VarIfLeftEnough, VarIfExists, VarIfArchived, VarIfLendbookIDExists;
    private int VarGetLendBookId;
    private BookRepository bookRepository;
    private Books bookAlreadySetToArchiveLater, bookIfLeftEnough, bookIfExists, bookIfArchived, bookArchiveBookForLater;
    private Booksstored booksstoredIfLeftEnough;
    private Bookstates bookstatesIfArchived;
    private Lendbooks lendbookIfLendbookIDExists, lendbookGetLendBookId;
    private Users userGetLendBookId;

    @BeforeEach
    void setUp() {
        //alreadySetToArchiveLater
        VarAlreadySetToArchiveLater = false;
        bookAlreadySetToArchiveLater = new Books();
        bookAlreadySetToArchiveLater.setId(2);
        bookRepository = BookRepository.getInstance();

        //ifLeftEnough
        VarIfLeftEnough = true;
        bookIfLeftEnough = new Books();
        bookIfLeftEnough.setId(1);
        booksstoredIfLeftEnough = new Booksstored();

        //ifExists
        VarIfExists = true;
        bookIfExists = new Books();
        bookIfExists.setId(1);

        //ifArchived
        VarIfArchived = false;
        bookIfArchived = new Books();
        bookIfArchived.setId(2);
        bookstatesIfArchived = new Bookstates();
        bookstatesIfArchived.setId(2);
        bookstatesIfArchived.setState("archived");

        //ifLendbookIDExists
        VarIfLendbookIDExists = true;
        lendbookIfLendbookIDExists = new Lendbooks();
        lendbookIfLendbookIDExists.setId(2);

        //getLendBookId
        VarGetLendBookId = 3;
        userGetLendBookId = new Users();
        userGetLendBookId.setId(2);
        lendbookGetLendBookId = new Lendbooks();
        lendbookGetLendBookId.setLenddate(11102021);

        //archiveBookForLater
        bookArchiveBookForLater = new Books();
        bookArchiveBookForLater.setId(1);

    }

    // DONE
    @Test
    void alreadySetToArchiveLater() {
        assertEquals(VarAlreadySetToArchiveLater,bookRepository.alreadySetToArchiveLater(bookAlreadySetToArchiveLater));
    }

    /*@Test
    void archiveBookForLater() {
    }

    @Test
    void addBook() {
    }

    @Test
    void removeBookFromAvailable() {
    }*/

    // DONE
    @Test
    void ifLeftEnough() {
        assertEquals(VarIfLeftEnough,bookRepository.ifLeftEnough(bookIfLeftEnough,booksstoredIfLeftEnough));
    }

    // DONE
    @Test
    void ifExists() {
        assertEquals(VarIfExists,bookRepository.ifExists(bookIfExists));
    }

    // DONE
    @Test
    void ifArchived() {
        assertEquals(VarIfArchived,bookRepository.ifArchived(bookIfArchived,bookstatesIfArchived));
    }

    /*@Test
    void archiveBook() {
    }

    @Test
    void deleteBook() {
    }*/

    // DONE
    @Test
    void ifLendbookIDExists() {
        assertEquals(VarIfLendbookIDExists,bookRepository.ifLendbookIDExists(lendbookIfLendbookIDExists));
    }

    // DONE
    @Test
    void getLendBookId() {
        assertEquals(VarGetLendBookId,bookRepository.getLendBookId(userGetLendBookId,lendbookGetLendBookId));
    }

    /*@Test
    void removeBookUserLend() {
    }

    @Test
    void addBookToAvailable() {
    }*/

    // DONE
    @Test
    void getBooksInfo() {
        assertNotNull(bookRepository.getBooksInfo());
    }

    // DONE
    @Test
    void getLendBooksInfo() {
        assertNotNull(bookRepository.getLendBooksInfo());
    }
}