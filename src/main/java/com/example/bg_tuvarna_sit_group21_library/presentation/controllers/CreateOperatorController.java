package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CreateOperatorController {

    private final AdminService service = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(AdminLoginController.class);

    @FXML
    public Button createOperatorButton;

    @FXML
    public TextField opName;

    @FXML
    public PasswordField opPass;

    @FXML
    public TextField opDate;

    @FXML
    public TextField opRating;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField opTwoNames;

    @FXML
    public TextField opPhone;

    @FXML
    public TextField opEmail;

    @FXML
    public Label wrongLabel;

    @FXML
    public void createOperatorButtonPressed(ActionEvent actionEvent) {
        if (opName.getText().isBlank()) {
            wrongLabel.setText("Enter a username");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opPass.getText().isBlank()) {
            wrongLabel.setText("Enter a password");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opDate.getText().isBlank()) {
            wrongLabel.setText("Enter a valid date (ex: 01012020)");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opRating.getText().isBlank()) {
            wrongLabel.setText("Enter rating from 1 to 10");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opTwoNames.getText().isBlank()) {
            wrongLabel.setText("Enter two names");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opPhone.getText().isBlank()) {
            wrongLabel.setText("Enter phone number - 10 numbers");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (opEmail.getText().isBlank()) {
            wrongLabel.setText("Enter an email");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else {
            String name = opName.getText();
            String pass = opPass.getText();
            String dateIf = opDate.getText();
            String rate = opRating.getText();
            String twoNames = opTwoNames.getText();
            String phone = opPhone.getText();
            String email = opEmail.getText();

            Statuses st = new Statuses();
            st.setId(1);

            Usertypes ut = new Usertypes();
            ut.setId(2);

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
                int date = Integer.parseInt(opDate.getText());

//                wrongLabel.setText("Operator added successfully");
//                wrongLabel.setTextFill(Color.GREEN);
//                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");

                Users u = new Users(name, pass, date, rate, st, ut);
                UserInfos v = new UserInfos(twoNames, phone, email, u);
                Forms f = new Forms(date, u);

                service.createOperator(u, v, f);
                log.info("Operator added successfully");

                wrongLabel.setText("Operator with ID: " + u.getId() + " added");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
        }
    }

    @FXML
    public void onGoBackButtonClick(ActionEvent actionEvent) throws IOException {
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
