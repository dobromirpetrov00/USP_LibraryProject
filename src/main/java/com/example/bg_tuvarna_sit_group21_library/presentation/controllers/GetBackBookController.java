package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Lendbooks;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
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

public class GetBackBookController {
    private final OperatorService service = OperatorService.getInstance();
    private final BookService bservice = BookService.getInstance();
    private static final Logger log = Logger.getLogger(GiveBookController.class);

    @FXML
    public Button getBackBookButton;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField rdUserId;

    @FXML
    public TextField rdUsername;

    @FXML
    public TextField rdPassword;

    @FXML
    public TextField bookId;

    @FXML
    public TextField lndbkIDfield;

    @FXML
    public Label wrongLabel;

    @FXML
    public void getBackBookButtonClick(ActionEvent actionEvent) {
        if (rdUserId.getText().isBlank() || rdUserId.getText().isEmpty()) {
            wrongLabel.setText("blank user id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdUsername.getText().isBlank() || rdUsername.getText().isEmpty()) {
            wrongLabel.setText("blank username");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (rdPassword.getText().isBlank() || rdPassword.getText().isEmpty()) {
            wrongLabel.setText("blank password");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (bookId.getText().isBlank() || bookId.getText().isEmpty()) {
            wrongLabel.setText("blank book id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (lndbkIDfield.getText().isBlank() || lndbkIDfield.getText().isEmpty()) {
            wrongLabel.setText("blank lendbook id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else {
            Integer readerID = Integer.parseInt(rdUserId.getText());
            Integer bookID = Integer.parseInt(bookId.getText());
            Integer lndbkID = Integer.parseInt(lndbkIDfield.getText());
            String username = rdUsername.getText();
            String password = rdPassword.getText();

            Books book = new Books();
            book.setId(bookID);

            Users reader = new Users();
            reader.setId(readerID);
            reader.setUsername(username);
            reader.setPassword(password);

            Lendbooks lendbook = new Lendbooks();
            lendbook.setId(lndbkID);

            if(!service.ifExistss(reader)){
                wrongLabel.setText("reader doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(!bservice.ifExist(book)){
                wrongLabel.setText("book doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(!bservice.checkIfLendBookIDExists(lendbook)){
                wrongLabel.setText("lendbook id doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                bservice.rmvBookUserLend(book, reader, lendbook);
                bservice.addBookAvailable(book);

                wrongLabel.setText("book returned successfully");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-alignment: center; -fx-background-color: white");

                log.info("book returned successfully");
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
