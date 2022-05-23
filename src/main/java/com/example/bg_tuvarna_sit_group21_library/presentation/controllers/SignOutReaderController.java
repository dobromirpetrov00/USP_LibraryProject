package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Forms;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.UserInfos;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import com.example.bg_tuvarna_sit_group21_library.services.OperatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.UnknownServiceException;

public class SignOutReaderController {
    private final OperatorService service = OperatorService.getInstance();
    private static final Logger log = Logger.getLogger(SignOutReaderController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button signOutReaderButton;

    @FXML
    public TextField rdUsername;

    @FXML
    public TextField rdID;

    @FXML
    public TextField rdPassword;

    @FXML
    public Label wrongLabel;

    @FXML
    public void signOutReaderButtonClick(ActionEvent actionEvent) {
        if(rdID.getText().isBlank() || rdID.getText().isEmpty()){
            wrongLabel.setText("blank id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else {
            Integer readerGetId = Integer.parseInt(rdID.getText());
            String readerGetUsername = rdUsername.getText();
            String readerGetPassword = rdPassword.getText();

            Users reader = new Users();
            reader.setId(readerGetId);
            reader.setUsername(readerGetUsername);
            reader.setPassword(readerGetPassword);

            UserInfos readerUserinfo = new UserInfos();
            readerUserinfo.setUsers(reader);

            Forms readerForm = new Forms();
            readerForm.setUsersUserid(reader);

            if(!service.ifExistss(reader)) {
                wrongLabel.setText("id doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                service.deleteReaderPr(reader, readerUserinfo, readerForm);

                log.info("Reader signed out successfully");
                wrongLabel.setText("Reader signed out successfully");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
        }
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Operator Menu");
        stage.setResizable(false);
        stage.show();
    }
}
