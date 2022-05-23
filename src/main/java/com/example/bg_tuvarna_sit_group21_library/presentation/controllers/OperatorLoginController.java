package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import com.example.bg_tuvarna_sit_group21_library.services.OperatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class OperatorLoginController {
    @FXML
    public TextField opUsername;

    @FXML
    public Button operatorLogin;

    @FXML
    public PasswordField opPassword;

    @FXML
    public Label labelWrongInfo;

    @FXML
    public Button goBackButton;

    private final OperatorService service = OperatorService.getInstance();
    private static final Logger log = Logger.getLogger(OperatorLoginController.class);

    @FXML
    public void onButtonClick(ActionEvent actionEvent) throws IOException {

        UsersListViewModel optoLogin = new UsersListViewModel(opUsername.getText().toString(),opPassword.getText().toString());
        PropertyConfigurator.configure(AdminLoginController.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));

        if (service.operatorLogin(optoLogin)) {
            Stage stage2 = (Stage) operatorLogin.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorView));
            Parent root = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Operator - " + opUsername.getText());
            stage.show();
            log.info("Operator " + opUsername.getText() + " logged successfully");
        }
        else {
            labelWrongInfo.setText("Invalid username or password");
            labelWrongInfo.setStyle("-fx-alignment: center; -fx-background-color: white");
            log.error("Wrong username or password");
        }
    }

    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HELLO_VIEW));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login Menu");
        stage.setResizable(false);
        stage.show();
    }
}