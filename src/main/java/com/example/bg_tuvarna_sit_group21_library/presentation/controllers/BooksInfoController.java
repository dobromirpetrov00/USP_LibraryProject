package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.BooksInfoListViewModel;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.SubmittedFormsListViewModel;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BooksInfoController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(BooksInfoController.class);

    @FXML
    public Button getBooksInfoButton;

    @FXML
    public Button goBackButton;

    @FXML
    public ListView bookInfoListView;

    @FXML
    public void getBooksInfoButtonClick(ActionEvent actionEvent) {
        ObservableList<BooksInfoListViewModel> booksInfoListViewModels = service.getAllBookInfo();
        bookInfoListView.setItems(booksInfoListViewModels);
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
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
