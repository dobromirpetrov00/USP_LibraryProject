package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.invoke.VarHandle;

import static org.junit.jupiter.api.Assertions.*;

class OperatorServiceTest {
    private OperatorService operatorService;
    private UsersListViewModel usersListViewModel;
    private boolean VarOperatorLogin;

    @BeforeEach
    void setUp() {
        operatorService=OperatorService.getInstance();
        VarOperatorLogin = true;
        String username = "stefani";
        String password = "1234";
        usersListViewModel = new UsersListViewModel(username,password);
    }

    // DONE
    @Test
    void getAllUsers() {
        assertNotNull(operatorService.getAllUsers());
    }

    @Test
    void operatorLogin() {
        assertEquals(VarOperatorLogin,operatorService.operatorLogin(usersListViewModel));
    }
}