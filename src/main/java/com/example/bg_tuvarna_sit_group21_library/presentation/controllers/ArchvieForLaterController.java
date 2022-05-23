package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Booksstored;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Bookstates;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Exemplars;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
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

public class ArchvieForLaterController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(ArchvieForLaterController.class);

    @FXML
    public Button remindToArchiveButton;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField bookIdForLater;

    @FXML
    public Label wrongLabel;

    @FXML
    public void remindToArchiveButtonClick(ActionEvent actionEvent) {
        if (bookIdForLater.getText().isBlank() || bookIdForLater.getText().isEmpty()) {
            wrongLabel.setText("blank id");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-alignment: center; -fx-background-color: white");
        }
        else {
            Integer bookIdGet = Integer.parseInt(bookIdForLater.getText());

            Books book = new Books();
            book.setId(bookIdGet);

            Bookstates bookstate = new Bookstates();
            bookstate.setId(2);
            bookstate.setState("archived");

            if (!service.ifExist(book)) {
                wrongLabel.setText("id doesn't exist");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (service.ifArchive(book, bookstate)) {
                wrongLabel.setText("book is already archived");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if (service.alreadySetForLater(book)){
                wrongLabel.setText("book is already set for archive later");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                Integer bookGetId = Integer.parseInt(bookIdForLater.getText());

                book.setId(bookGetId);
                book.setIsarchived("yes");

                service.archiveBookLater(book);

                wrongLabel.setText("Book successfully set for archive later");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-alignment: center; -fx-background-color: white");

                log.info("Book successfully set for archive later");
            }
        }
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.bookOptionsView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Book Menu");
        stage.show();
    }
}
