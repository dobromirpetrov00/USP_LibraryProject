package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
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

public class CreateReaderProfileController {
    private final OperatorService service = OperatorService.getInstance();
    private static final Logger log = Logger.getLogger(CreateReaderProfileController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button createReaderButton;

    @FXML
    public TextField rdUsername;

    @FXML
    public TextField rdPassword;

    @FXML
    public TextField rdApprovalDate;

    @FXML
    public TextField rdRating;

    @FXML
    public TextField rdTwoNames;

    @FXML
    public TextField rdPhone;

    @FXML
    public TextField rdEmail;

    @FXML
    public Label wrongLabel;

    @FXML
    public void createReaderButtonClick(ActionEvent actionEvent) {
        if (rdUsername.getText().isBlank()) {
            wrongLabel.setText("Enter a username");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdPassword.getText().isBlank()) {
            wrongLabel.setText("Enter a password");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdApprovalDate.getText().isBlank()) {
            wrongLabel.setText("Enter a valid date (ex: 01012020)");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdRating.getText().isBlank()) {
            wrongLabel.setText("Enter rating from 1 to 10");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdTwoNames.getText().isBlank()) {
            wrongLabel.setText("Enter two names");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdPhone.getText().isBlank()) {
            wrongLabel.setText("Enter phone number - 10 numbers");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdEmail.getText().isBlank()) {
            wrongLabel.setText("Enter an email");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else {
            String name = rdUsername.getText();
            String pass = rdPassword.getText();
            String dateIf = rdApprovalDate.getText();
            String rate = rdRating.getText();
            String twoNames = rdTwoNames.getText();
            String phone = rdPhone.getText();
            String email = rdEmail.getText();

            Statuses st = new Statuses();
            st.setId(1);

            Usertypes ut = new Usertypes();
            ut.setId(3);

            if (name.isBlank()) {
                wrongLabel.setText("Enter a username");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (name.length() > 30) {
                wrongLabel.setText("Username must be less than 30 letters");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (pass.isBlank()) {
                wrongLabel.setText("Enter a password");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (pass.length() > 30) {
                wrongLabel.setText("Password must be less than 30 letters");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (dateIf.isBlank() || dateIf.length() != 8) {
                wrongLabel.setText("Enter a valid date (ex: 01012020)");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (rate.isBlank() || Integer.parseInt(rate) < 1 || Integer.parseInt(rate) > 10) {
                wrongLabel.setText("Enter rating from 1 to 10");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (twoNames.isBlank()) {
                wrongLabel.setText("Enter two names");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (phone.isBlank() || phone.length() != 10) {
                wrongLabel.setText("Enter phone number - 10 numbers");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (email.isBlank()) {
                wrongLabel.setText("Enter an email");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                int date = Integer.parseInt(rdApprovalDate.getText());

//                wrongLabel.setText("Reader added successfully");
//                wrongLabel.setTextFill(Color.GREEN);
//                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");

                Users u = new Users(name, pass, date, rate, st, ut);
                UserInfos v = new UserInfos(twoNames, phone, email, u);
                Forms f = new Forms(date, u);

                service.createReaderProfile(u, v, f);
                log.info("Reader added successfully");

                wrongLabel.setText("Reader with ID: " + u.getId() + " added");
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
