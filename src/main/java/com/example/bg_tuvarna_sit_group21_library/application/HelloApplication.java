package com.example.bg_tuvarna_sit_group21_library.application;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    private static final Logger log = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {
        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path = getClass().getResource(Constants.View.HELLO_VIEW);

        if (path != null) {
            Parent root = FXMLLoader.load(path);
            Scene scene = new Scene(root);

            stage.setResizable(false);
            stage.setTitle("Login Menu");
            stage.setScene(scene);
            stage.show();
        } else {
            log.error("Sorry, the main fxm could not be loaded.");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}