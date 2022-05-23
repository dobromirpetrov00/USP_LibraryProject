package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class OperatorController {
    @FXML
    public Button goBackButton;

    @FXML
    public Button createReaderProfileButton;

    @FXML
    public Button giveBookButton;

    @FXML
    public Button getBackBookButton;

    @FXML
    public Button signOutReaderButton;

    @FXML
    public Button referencesButton;

    @FXML
    public void createReaderProfileButtonClick(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setResizable(false);
        alert.setTitle("Create Reader Profile");
        alert.setHeaderText("You are about to create a reader profile!");
        alert.setContentText("CONTINUE ?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Stage stage2 = (Stage) goBackButton.getScene().getWindow();
                stage2.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.createReaderProfileView));
                Parent root = (Parent) fxmlLoader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Create Reader Profile");
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorLoginView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Operator Login");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void giveBookButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) giveBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.giveBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Give Book");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void getBackBookButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) getBackBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.getBackBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Get Back Book");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void signOutReaderButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) signOutReaderButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.signOutReaderView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Sign Out Reader");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void referencesButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) referencesButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.referencesView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("References Menu");
        stage.setResizable(false);
        stage.show();
    }
}