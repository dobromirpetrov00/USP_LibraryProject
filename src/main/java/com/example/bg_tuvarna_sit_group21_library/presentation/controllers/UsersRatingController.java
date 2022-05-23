package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersRatingListViewModel;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
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

public class UsersRatingController {
    private final AdminService service = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(UsersRatingController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button getUsersRatingButton;

    @FXML
    public ListView usersRatingListView;

    @FXML
    public void getUsersRatingButtonClick(ActionEvent actionEvent) {
        ObservableList<UsersRatingListViewModel> usersRatingListViewModels = service.getAllUsersRating();
        usersRatingListView.setItems(usersRatingListViewModels);
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.adminView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Administrator Menu");
        stage.show();
    }
}
