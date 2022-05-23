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

public class ArchiveBookController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(ArchiveBookController.class);

    @FXML
    public TextField bookArchiveId;

    @FXML
    public Label bookInfoLabel;

    @FXML
    public Button archiveBookButton;

    @FXML
    public Button goBackButton;

    @FXML
    public void archiveBookButtonClick(ActionEvent actionEvent) {

        if (bookArchiveId.getText().isBlank() || bookArchiveId.getText().isEmpty()) {
            bookInfoLabel.setText("blank id");
            bookInfoLabel.setTextFill(Color.RED);
            bookInfoLabel.setStyle("-fx-alignment: center; -fx-background-color: white");
        } else {
            Integer bookIdGet = Integer.parseInt(bookArchiveId.getText());

            Books book = new Books();
            book.setId(bookIdGet);

            Bookstates bookstate = new Bookstates();
            bookstate.setId(2);
            bookstate.setState("archived");

            if (!service.ifExist(book)) {
                bookInfoLabel.setText("id doesn't exist");
                bookInfoLabel.setTextFill(Color.RED);
                bookInfoLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else if(service.ifArchive(book, bookstate)){
                bookInfoLabel.setText("book is already archived");
                bookInfoLabel.setTextFill(Color.RED);
                bookInfoLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
            }
            else {
                Integer bookGetId = Integer.parseInt(bookArchiveId.getText());

                //Books
                book.setId(bookGetId);

                //Exemplars
                Exemplars exemplar = new Exemplars();
                exemplar.setBookBookid(book);
                exemplar.setStateStateid(bookstate);

                //Booksstored
                Booksstored booksstored = new Booksstored();
                booksstored.setBooks(book);

                service.archivedBook(book, exemplar, booksstored);

                bookInfoLabel.setText("Book archived succesfully");
                bookInfoLabel.setTextFill(Color.GREEN);
                bookInfoLabel.setStyle("-fx-alignment: center; -fx-background-color: white");

                log.info("Book archived successfully");
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
