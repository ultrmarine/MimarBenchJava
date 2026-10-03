package com.taskmanager.controller;

import com.taskmanager.model.hardware.CpuMetrics;
import com.taskmanager.model.hardware.GpuMetrics;
import com.taskmanager.model.hardware.MemoryMetrics;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainController {
    private CpuMetrics cpuMetrics = new CpuMetrics(); // обращаемся к файлам с функциями вывода данных и бла бла бла
    private GpuMetrics gpuMetrics = new GpuMetrics();
    private MemoryMetrics memoryMetrics = new MemoryMetrics();

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
    // Это все таблицы в processes,я присвоил им айдишники,чтобы потом в названиях писать процент их нагрузки(украл фичу из Диспетчера задач)
    @FXML
    private TableColumn processColumnName;
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

    // Это всё правые экраны в performance,должны быть подключены к кнопочкам
    @FXML
    private StackPane performanceStackPaneCpu;
    @FXML
    private StackPane performanceStackPaneMemory;
    @FXML
    private StackPane performanceStackPaneDisk;
    @FXML
    private StackPane performanceStackPaneEthernet;
    @FXML
    private StackPane performanceStackPaneGpu;

    // Это все кнопочки в performance
    @FXML
    private ToggleGroup performanceButton;
    @FXML
    private ToggleButton performanceButtonCpu;
    @FXML
    private ToggleButton performanceButtonMemory;
    @FXML
    private ToggleButton performanceButtonDisk;
    @FXML
    private ToggleButton performanceButtonEthernet;
    @FXML
    private ToggleButton performanceButtonGpu;

    // тут начинается обращение к PC Specs окну
    //данные в окошке CPU
    @FXML
    private Label specsCpuName;
    @FXML
    private Label specsCpuCores;

    //данные в окошке GPU
    @FXML
    private Label specsGpuName;
    @FXML
    private Label specsGpuVendor;
    @FXML
    private Label specsGpuVram;

    //данные в окошке Memory
    @FXML
    private Label specsMemoryTotal;
    @FXML
    private Label specsMemoryInfo;



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

        specsCpuName.setText("Processor name: " + cpuMetrics.getName());
        specsCpuCores.setText("Number of physical cores: " + String.valueOf(cpuMetrics.getPhysicalCores()));

        specsGpuName.setText("Processor name: " + gpuMetrics.getName());
        specsGpuVendor.setText("Processor Vendor: " + gpuMetrics.getVendor());
        specsGpuVram.setText("Processor Vram: " + gpuMetrics.getVram() + "G");

        specsMemoryTotal.setText("Memory Total: " + String.valueOf(memoryMetrics.getTotal()));
        //Нужно думать как разбивать всю инфу о плашках,в теории можно прямо в функции выводить всё по отдельности
//        Label label = new Label("" + String.valueOf(memoryMetrics.getPhysMem()));
//        specsMemoryInfo.getChildren().add(label);
//        processColumnName.setText("Name");
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