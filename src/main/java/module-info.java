module com.example.bg_tuvarna_sit_group21_library {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.persistence;
    requires log4j;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.example.bg_tuvarna_sit_group21_library.database.Connect to org.hibernate.orm.core;
    exports com.example.bg_tuvarna_sit_group21_library.database.Connect;

    opens com.example.bg_tuvarna_sit_group21_library.database.Entities to org.hibernate.orm.core;
    exports com.example.bg_tuvarna_sit_group21_library.database.Entities;

    exports com.example.bg_tuvarna_sit_group21_library.application;
    opens com.example.bg_tuvarna_sit_group21_library.application to javafx.fxml;

    exports com.example.bg_tuvarna_sit_group21_library.presentation.models;
    opens com.example.bg_tuvarna_sit_group21_library.presentation.models to javafx.fxml;

    //exports com.example.bg_tuvarna_sit_group21_library.presentation;
    //opens com.example.bg_tuvarna_sit_group21_library.presentation to javafx.fxml;

    exports com.example.bg_tuvarna_sit_group21_library.presentation.controllers;
    opens com.example.bg_tuvarna_sit_group21_library.presentation.controllers to javafx.fxml;
}