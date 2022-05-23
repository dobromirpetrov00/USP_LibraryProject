package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.LendBooksInfoListViewModel;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UserInfoListViewModel;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UserInfoListViewModelNoImportant;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class UsersInfoController2 {
    private final BookService bservice = BookService.getInstance();
    private final AdminService aservice = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(BooksInfoController.class);

    @FXML
    public ListView userInfoListView;

    @FXML
    public ListView lendBooksListView;

    @FXML
    public Button getUserInfoButton;

    @FXML
    public Button getLendBooksButton;

    @FXML
    public Button goBackButton;

    @FXML
    public void getUserInfoButtonClick(ActionEvent actionEvent) {
        ObservableList<UserInfoListViewModelNoImportant> userInfoListViewModels = aservice.getUserInfoNoImportant();
        userInfoListView.setItems(userInfoListViewModels);
    }

    @FXML
    public void getLendBooksButtonClick(ActionEvent actionEvent) {
        ObservableList<LendBooksInfoListViewModel> lendBooksInfoListViewModels = bservice.getLendBooksInfos();
        lendBooksListView.setItems(lendBooksInfoListViewModels);
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.referencesView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("References Menu");
        stage.show();
    }
}
