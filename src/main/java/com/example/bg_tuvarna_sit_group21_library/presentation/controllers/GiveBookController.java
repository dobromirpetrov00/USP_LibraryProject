package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
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

public class GiveBookController {
    private final OperatorService service = OperatorService.getInstance();
    private final BookService bservice = BookService.getInstance();
    private static final Logger log = Logger.getLogger(GiveBookController.class);

    @FXML
    public Button giveBookButton;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField userIdField;

    @FXML
    public TextField lendDateField;

    @FXML
    public TextField bookIdField;

    @FXML
    public Label wrongLabel;

    @FXML
    public Label lndbkIDLabel;

    @FXML
    public void giveBookButtonClick(ActionEvent actionEvent) {
        if (userIdField.getText().isBlank() || userIdField.getText().isEmpty()) {
            wrongLabel.setText("blank user id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (bookIdField.getText().isBlank() || bookIdField.getText().isEmpty()) {
            wrongLabel.setText("blank book id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else if (lendDateField.getText().isBlank() || lendDateField.getText().isEmpty()) {
            wrongLabel.setText("blank lend date");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        }
        else {
            int lenderId = Integer.parseInt(userIdField.getText());
            int lendBookId = Integer.parseInt(bookIdField.getText());
            int lendDate = Integer.parseInt(lendDateField.getText());

            Users lender = new Users();
            lender.setId(lenderId);

            Books book = new Books();
            book.setId(lendBookId);

            Booksstored booksstored = new Booksstored();
            booksstored.setBooks(book);

            Lendbooks lendbook = new Lendbooks();
            lendbook.setUsersUserid(lender);
            lendbook.setLenddate(lendDate);

            Lendinfos lendinfo = new Lendinfos();
            lendinfo.setBookBookid(book);
            lendinfo.setLendLendbooksid(lendbook);

            if(!service.ifReaderExist(lender)){
                wrongLabel.setText("reader doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(!bservice.ifExist(book)){
                wrongLabel.setText("book doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(lendDateField.getText().length() != 8){
                wrongLabel.setText("invalid date (ex. 01012020)");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(!bservice.ifLeftEn(book,booksstored)) {
                wrongLabel.setText("no books left to lend");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                service.lendABook(lender, book, lendinfo, lendbook);
                bservice.rmvOneBookFromAvailable(book);

                int lndbkid = bservice.getLndBkID(lender,lendbook);
                String lbid = String.valueOf(lndbkid);
                lndbkIDLabel.setText("lendbookd id: " + lbid);
                lndbkIDLabel.setTextFill(Color.GREEN);
                lndbkIDLabel.setStyle("-fx-alignment: center; -fx-background-color: white");

                wrongLabel.setText("book lent successfully");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-alignment: center; -fx-background-color: white");

                log.info("book lent successfully");
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
