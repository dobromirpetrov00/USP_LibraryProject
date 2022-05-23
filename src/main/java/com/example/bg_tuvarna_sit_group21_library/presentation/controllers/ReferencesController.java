package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ReferencesController {
    @FXML
    public Button submittedFormsButton;

    @FXML
    public Button usersInfoButton;

    @FXML
    public Button usersRatingButton;

    @FXML
    public Button bookInfoButton;

    @FXML
    public Button goBackButton;

    @FXML
    public void submittedFormsButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) submittedFormsButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.submittedFormsView2));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Submitted Forms");
        stage.show();
    }

    @FXML
    public void usersInfoButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) usersInfoButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.usersInfoView2));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Users Info");
        stage.show();
    }

    @FXML
    public void usersRatingButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) usersRatingButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.usersRatingView2));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Users Rating");
        stage.show();
    }

    @FXML
    public void bookInfoButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) bookInfoButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.bookInfosView2));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Books Info");
        stage.show();
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Operator Menu");
        stage.show();
    }
}
