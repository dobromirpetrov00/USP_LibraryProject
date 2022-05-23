package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.UserRepository;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorService {
    private final UserRepository repository = UserRepository.getInstance();

    public static OperatorService getInstance() {
        return OperatorService.OperatorServiceHolder.INSTANCE;
    }

    private static class OperatorServiceHolder {
        public static final OperatorService INSTANCE = new OperatorService();
    }

    public ObservableList<UsersListViewModel> getAllUsers() {
        List<Users> users = repository.getAllUsers();

        return FXCollections.observableList(
                users
                        .stream()
                        .map(t -> new UsersListViewModel(
                                t.getId(),
                                t.getUsername(),
                                t.getPassword(),
                                t.getApprovaldate(),
                                t.getRating(),
                                t.getStatusStatusid().getId(),
                                t.getUserUsertypeid().getId()
                        )).collect(Collectors.toList()));
    }

    public void lendABook(Users lender, Books book, Lendinfos lendinfo, Lendbooks lendbook) {
        repository.lendBook(lender,book,lendinfo,lendbook);
    }

    public void createReaderProfile(Users a, UserInfos v, Forms f){
        repository.createReader(a, v, f);
    }

    public void deleteReaderPr(Users u, UserInfos v, Forms f) { repository.deleteReader(u, v, f); }

    public boolean ifExistss(Users reader) { return repository.ifExists(reader); }

    public boolean ifReaderExist(Users reader) { return repository.ifReaderExists(reader); }

    public boolean operatorLogin(UsersListViewModel a) {

        ObservableList<UsersListViewModel> allUsers = getAllUsers();
        boolean login = false;

        for(UsersListViewModel oper:allUsers) {
            if(oper.getUsername().equals(a.getUsername())) {
                if (oper.getPassword().equals(a.getPassword()))
                    if (oper.getUser_usertypeid()== 2)
                        login = true;
            }
        }

        return login;
    }
}
