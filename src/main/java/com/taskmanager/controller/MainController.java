package com.taskmanager.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController {
    @FXML
    private TabPane tabPane;

    @FXML
    private CheckMenuItem checkMenuItem;

    @FXML
    private Label cpu; // название переменных и есть их айдишник,айдишник прописываю в scenebuilder

    @FXML
    private Label ram;

    @FXML
    private Label testlabel;


    @FXML
    public void initialize() {
        cpu.setText("CPU: TEXT LOLL");
        ram.setText("RAM: LOLL");
        testlabel.setText("TESTLABEL: TEXT LOLL");
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }


}