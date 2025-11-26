package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        AppA2.open(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
