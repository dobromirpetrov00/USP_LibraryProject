package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.SubmittedFormsListViewModel;
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

public class SubmittedFormsController {
    private final AdminService service = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(SubmittedFormsController.class);

    @FXML
    public ListView submittedFormsListView;

    @FXML
    public Button getSubmittedFormsButton;

    @FXML
    public Button goBackButton;

    @FXML
    public void getSubmittedFormsButtonClick(ActionEvent actionEvent) {
        ObservableList<SubmittedFormsListViewModel> submittedFormsListViewModels = service.getSubmForms();
        submittedFormsListView.setItems(submittedFormsListViewModels);
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
