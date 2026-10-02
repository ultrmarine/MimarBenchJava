package com.taskmanager.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

public class MainController {
    // название переменных и есть их айдишник,айдишник прописываю в scenebuilder
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab process; // Все Tab относяткся к боковой панельке с процессами,performance ja nii edasi
    @FXML
    private Tab performance;
    @FXML
    private Tab specs;

    // да названия длинноваты чёта,но так как название = айди,я не мог по другому их сделать
    @FXML
    private TableColumn processColumnName; // Это все таблицы в processes
    @FXML
    private TableColumn processColumnStatus;
    @FXML
    private TableColumn processColumnCpu;
    @FXML
    private TableColumn processColumnMemory;
    @FXML
    private TableColumn processColumnDisk;
    @FXML
    private TableColumn processColumnNetwork;

    @FXML
    private StackPane performanceStackPaneCpu; // Это всё правые экраны в performance,должны быть подключены к кнопочкам
    @FXML
    private StackPane performanceStackPaneMemory;
    @FXML
    private StackPane performanceStackPaneDisk;
    @FXML
    private StackPane performanceStackPaneEthernet;
    @FXML
    private StackPane performanceStackPaneGpu;

    @FXML
    private ToggleGroup performanceButton;
    @FXML
    private ToggleButton performanceButtonCpu; // Это все кнопочки в performance
    @FXML
    private ToggleButton performanceButtonMemory;
    @FXML
    private ToggleButton performanceButtonDisk;
    @FXML
    private ToggleButton performanceButtonEthernet;
    @FXML
    private ToggleButton performanceButtonGpu;

    @FXML
    public void initialize() {
        windowPerformaceSwitch(); // скрываем все окна
        performanceStackPaneCpu.setVisible(true); // оставляем активным только проц

        performanceButton.selectedToggleProperty().addListener((obj, oldToggle, newToggle) -> { // запрещаем отжимать кнопку в перформанс и кстати лоол да это же адд листенер,прям как в js,непозволительная роскошь от джавафх
            if (newToggle == null) {
                oldToggle.setSelected(true);
            } else {
                windowPerformaceSwitch(); // при нажатии вызываем каждое окно
            }
        });

        processColumnName.setText("Name");
    }

    @FXML
    private void windowPerformaceSwitch() { // функция для смены окон в перформанс по кнопкам
        performanceStackPaneCpu.setVisible(false);
        performanceStackPaneMemory.setVisible(false);
        performanceStackPaneDisk.setVisible(false);
        performanceStackPaneEthernet.setVisible(false);
        performanceStackPaneGpu.setVisible(false);

        if (performanceButtonMemory.isSelected()) {
            performanceStackPaneMemory.setVisible(true);
        } else if (performanceButtonCpu.isSelected()) {
            performanceStackPaneCpu.setVisible(true);
        } else if (performanceButtonDisk.isSelected()) {
            performanceStackPaneDisk.setVisible(true);
        } else if (performanceButtonEthernet.isSelected()) {
            performanceStackPaneEthernet.setVisible(true);
        } else if (performanceButtonGpu.isSelected()) {
            performanceStackPaneGpu.setVisible(true);
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }


}