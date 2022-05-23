package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    public Button exitButton;

    @FXML
    private Button operatorLoginButton;

    @FXML
    private Button adminLoginButton;

    @FXML
    public void onOperatorLoginButtonClick(ActionEvent actionEvent){

        try {
            Stage stage2 = (Stage) operatorLoginButton.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorLoginView));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Operator Login");
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void onAdminLoginButtonClick(ActionEvent actionEvent) {
        try {
            Stage stage2 = (Stage) adminLoginButton.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.adminLoginView));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Admin Login");
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void exitButtonClick(ActionEvent actionEvent) {
        Stage stage2 = (Stage) exitButton.getScene().getWindow();
        stage2.close();
    }
}