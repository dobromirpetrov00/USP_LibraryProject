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

public class AdministratorController {
    @FXML
    public Button createOperator;

    @FXML
    public Button bookOptions;

    @FXML
    public Button goBackButton;

    @FXML
    public Button submittedFormsButton;

    @FXML
    public Button booksInfoButton;

    @FXML
    public Button usersInfoButton;

    @FXML
    public Button usersRatingButton;

    @FXML
    public void onCreateOperatorButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) createOperator.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.createOperatorView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Create Operator");
        stage.show();
    }

    @FXML
    public void onBookOptionsButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) bookOptions.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.bookOptionsView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Book Menu");
        stage.show();
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.adminLoginView));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Admin Login");
        stage.show();
    }

    @FXML
    public void submittedFormsButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) submittedFormsButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.submittedFormsView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Submitted Forms");
        stage.show();
    }

    @FXML
    public void booksInfoButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) booksInfoButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.bookInfosView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Books Info");
        stage.show();
    }

    @FXML
    public void usersInfoButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) usersInfoButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.usersInfoView));
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.usersRatingView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Users Rating");
        stage.show();
    }
}
