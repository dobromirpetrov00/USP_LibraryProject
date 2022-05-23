package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Lendbooks;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Lendinfos;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;
    private boolean VarIfReaderExists, VarIfExists;
    private Users userIfReaderExists, userIfExists;

    @BeforeEach
    void setUp() {
        //ifReaderExists
        userRepository = UserRepository.getInstance();
        VarIfReaderExists = true;
        userIfReaderExists = new Users();
        userIfReaderExists.setId(1);

        //ifExists
        VarIfExists = true;
        userIfExists = new Users();
        userIfExists.setId(2);
        userIfExists.setUsername("lyuboslav");
        userIfExists.setPassword("1234");
    }

    // DONE
    @Test
    void getSubmittedFormsAll() {
        assertNotNull(userRepository.getSubmittedFormsAll());
    }

    // DONE
    @Test
    void getUsersRatingAll() {
        assertNotNull(userRepository.getUsersRatingAll());
    }

    // DONE
    @Test
    void getAllUsers() {
        assertNotEquals(null,userRepository.getAllUsers());
    }

    // DONE
    @Test
    void getAllNeedToBeArchived() {
        assertNotNull(userRepository.getAllNeedToBeArchived());
    }

/*    @Test
    void lendBook() {
    }

    @Test
    void createUser() {
    }

    @Test
    void createReader() {
    }

    @Test
    void deleteReader() {
    }*/

    // DONE
    @Test
    void ifReaderExists() {
        assertEquals(VarIfReaderExists,userRepository.ifReaderExists(userIfReaderExists));
    }

    // DONE
    @Test
    void ifExists() {
        assertEquals(VarIfExists,userRepository.ifExists(userIfExists));
    }

    @Test
    void getUsersInfo() {
        assertNotNull(userRepository.getUsersInfo());
    }
}