package com.taskmanager.app;


import com.taskmanager.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml")); // путь к разметке для javafx,в ней же и указан путь к контролеру


        Parent root = loader.load();

        MainController controller = loader.getController(); // вывожу,тот ли контролер я ваще получаю

        System.out.println(controller);

        Scene scene = new Scene(root, 1500,900); //размер окна

        stage.setTitle("Martin testit");
        stage.setScene(scene);
        stage.show();
    }
}