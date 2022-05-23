package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
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

public class AddBookController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(AddBookController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button addBookButton;

    @FXML
    public TextField bookName;

    @FXML
    public TextField bookAuthor;

    @FXML
    public TextField bookGenre;

    @FXML
    public TextField bookYear;

    @FXML
    public TextField bookIsForArchive;

    @FXML
    public TextField bookTotal;

    @FXML
    public TextField bookAvailable;

    @FXML
    public TextField bookReadingRoom;

    @FXML
    public Label wrongLabel;

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

    @FXML
    public void addBookButtonClick(ActionEvent actionEvent) {

        if(bookName.getText().isBlank()){
            wrongLabel.setText("Enter book name");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookAuthor.getText().isBlank()){
            wrongLabel.setText("Enter author name");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookGenre.getText().isBlank()){
            wrongLabel.setText("Enter genre");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookYear.getText().isBlank()){
            wrongLabel.setText("Enter valid year");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookIsForArchive.getText().isBlank()){
            wrongLabel.setText("Enter for archive - yes/no");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookTotal.getText().isBlank()){
            wrongLabel.setText("Enter total books");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookAvailable.getText().isBlank()){
            wrongLabel.setText("Enter available books");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else if(bookReadingRoom.getText().isBlank()){
            wrongLabel.setText("Enter books for reading room");
            wrongLabel.setTextFill(Color.RED);
            wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
        }
        else {
            //info za books
            String name = bookName.getText();
            String author = bookAuthor.getText();
            String genre = bookGenre.getText();
            String yearIf = bookYear.getText();
            String isForArchive = bookIsForArchive.getText();

            //info za booksstored
            String totalIf = bookTotal.getText();
            String availableIf = bookAvailable.getText();
            String readingRoomIf = bookReadingRoom.getText();

            Integer totalIf2 = Integer.parseInt(bookTotal.getText());
            Integer availableIf2 = Integer.parseInt(bookAvailable.getText());
            Integer readingRoomIf2 = Integer.parseInt(bookReadingRoom.getText());

            String yes = "yes";
            String no = "no";

            if(name.isBlank()){
                wrongLabel.setText("Enter book name");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(author.isBlank()){
                wrongLabel.setText("Enter author name");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(genre.isBlank()){
                wrongLabel.setText("Enter genre");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(yearIf.isBlank() || Integer.parseInt(yearIf)>2021 || Integer.parseInt(yearIf)<1){
                wrongLabel.setText("Enter valid year");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(isForArchive.isBlank() || (!isForArchive.equals(yes) && !isForArchive.equals(no))){
                wrongLabel.setText("Enter for archive - yes/no");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(totalIf.isBlank()){
                wrongLabel.setText("Enter total books");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(totalIf2 != availableIf2 + readingRoomIf2){
                wrongLabel.setText("Book pieces don't match");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(availableIf2 != totalIf2 - readingRoomIf2){
                wrongLabel.setText("Book pieces don't match");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(readingRoomIf2 != totalIf2 - availableIf2){
                wrongLabel.setText("Book pieces don't match");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(availableIf.isBlank()){
                wrongLabel.setText("Enter available books");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else if(readingRoomIf.isBlank()){
                wrongLabel.setText("Enter books for reading room");
                wrongLabel.setTextFill(Color.RED);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
            else {

                int total = Integer.parseInt(bookTotal.getText());
                int available = Integer.parseInt(bookAvailable.getText());
                int readingRoom = Integer.parseInt(bookReadingRoom.getText());
                int year = Integer.parseInt(bookYear.getText());

//                wrongLabel.setText("Book with ID: " +  +" added successfully");
//                wrongLabel.setTextFill(Color.GREEN);
//                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");

                //define Books
                Books book = new Books(name, author, genre, year, isForArchive);

                //define Booksstored
                Booksstored booksstored = new Booksstored(total, available, readingRoom, book);

                //set id Bookstates
                Bookstates bs = new Bookstates();
                bs.setId(1);

                //define Exemplars
                Exemplars ex = new Exemplars(book, bs);

                service.addBook(book, booksstored, ex);
                log.info("Book added successfully");

                //Long addedBookId = service.getAddedBookId(book);

                wrongLabel.setText("Book with ID: " + book.getId() +" added successfully");
                wrongLabel.setTextFill(Color.GREEN);
                wrongLabel.setStyle("-fx-background-color: white;-fx-alignment: center");
            }
        }
    }

//    @FXML
//    public void addBookButtonClick(ActionEvent actionEvent) {
//
//        //info za books
//        String name = bookName.getText();
//        String author = bookAuthor.getText();
//        String genre = bookGenre.getText();
//        String yearIf = bookYear.getText();
//        String isForArchive = bookIsForArchive.getText();
//
//        //info za booksstored
//        String totalIf = bookTotal.getText();
//        String availableIf = bookAvailable.getText();
//        String readingRoomIf = bookReadingRoom.getText();
//
//        Integer totalIf2 = Integer.parseInt(bookTotal.getText());
//        Integer availableIf2 = Integer.parseInt(bookAvailable.getText());
//        Integer readingRoomIf2 = Integer.parseInt(bookReadingRoom.getText());
//
//        String yes = "yes";
//        String no = "no";
//
//        if(bookName.getText().isBlank())
//            wrongLabel.setText("Enter book name");
//
//        if(name.isBlank()){
//            wrongLabel.setText("Enter book name");
//        }
//        else if(author.isBlank()){
//            wrongLabel.setText("Enter author name");
//        }
//        else if(genre.isBlank()){
//            wrongLabel.setText("Enter genre");
//        }
//        else if(yearIf.isBlank() || Integer.parseInt(yearIf)>2021 || Integer.parseInt(yearIf)<1){
//            wrongLabel.setText("Enter valid year");
//        }
//        else if(isForArchive.isBlank() || (!isForArchive.equals(yes) && !isForArchive.equals(no))){
//            wrongLabel.setText("Enter for archive - yes/no");
//        }
//        else if(totalIf.isBlank()){
//            wrongLabel.setText("Enter total books");
//        }
//        else if(totalIf2 != availableIf2 + readingRoomIf2){
//            wrongLabel.setText("Book pieces don't match");
//        }
//        else if(availableIf2 != totalIf2 - readingRoomIf2){
//            wrongLabel.setText("Book pieces don't match");
//        }
//        else if(readingRoomIf2 != totalIf2 - availableIf2){
//            wrongLabel.setText("Book pieces don't match");
//        }
//        else if(availableIf.isBlank()){
//            wrongLabel.setText("Enter available books");
//        }
//        else if(readingRoomIf.isBlank()){
//            wrongLabel.setText("Enter books for reading room");
//        }
//        else {
//            int total = Integer.parseInt(bookTotal.getText());
//            int available = Integer.parseInt(bookAvailable.getText());
//            int readingRoom = Integer.parseInt(bookReadingRoom.getText());
//            int year = Integer.parseInt(bookYear.getText());
//
//            wrongLabel.setText("Book added successfully");
//            wrongLabel.setTextFill(Color.GREEN);
//
//            //define Books
//            Books book = new Books(name, author, genre, year, isForArchive);
//
//            //define Booksstored
//            Booksstored booksstored = new Booksstored(total, available, readingRoom, book);
//
//            //set id Bookstates
//            Bookstates bs = new Bookstates();
//            bs.setId(1);
//
//            //define Exemplars
//            Exemplars ex = new Exemplars(book, bs);
//
//            service.addBook(book, booksstored, ex);
//            log.info("Book added successfully");
//        }
//    }
}
