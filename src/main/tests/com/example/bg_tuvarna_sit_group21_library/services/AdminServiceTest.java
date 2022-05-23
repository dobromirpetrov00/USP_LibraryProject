package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.repositories.UserRepository;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private AdminService adminService;
    private boolean VarAdminLogin;
    private UsersListViewModel usersListViewModel;

    @BeforeEach
    void setUp() {
        adminService=AdminService.getInstance();
        VarAdminLogin = true;
        String username = "dobromir";
        String password = "1234";
        usersListViewModel = new UsersListViewModel(username,password);
    }

    // DONE
    @Test
    void getSubmForms() {
        assertNotNull(adminService.getSubmForms());
    }

    // DONE
    @Test
    void getAllUsersRating() {
        assertNotNull(adminService.getAllUsersRating());
    }

    // DONE
    @Test
    void getUserInfoAll() {
        assertNotNull(adminService.getUserInfoAll());
    }

    // DONE
    @Test
    void getAllUsers() {
        assertNotNull(adminService.getAllUsers());
    }

    // DONE
    @Test
    void adminLogin() {
        assertEquals(VarAdminLogin,adminService.adminLogin(usersListViewModel));
    }
}