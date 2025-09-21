package org.example.A6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.A2.AppA2;
import org.example.A3A.AppA3A;
import org.example.A3B.AppA3B;
import org.example.A4.AppA4;
import org.example.A5.AppA5;

public class A6App extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Button btnA2 = createButton("Open A2");
        Button btnA3A = createButton("Open A3A");
        Button btnA3B = createButton("Open A3B");
        Button btnA4 = createButton("Open A4");
        Button btnA5 = createButton("Open A5");
        Button btnExit = createButton("Exit");

        btnA2.setOnAction(e -> AppA2.open(primaryStage));
        btnA3A.setOnAction(e -> AppA3A.open(primaryStage));
        btnA3B.setOnAction(e -> AppA3B.open(primaryStage));
        btnA4.setOnAction(e -> AppA4.open(primaryStage));
        btnA5.setOnAction(e -> AppA5.open(primaryStage));
        btnExit.setOnAction(e -> primaryStage.close());

        root.getChildren().addAll(btnA2, btnA3A, btnA3B, btnA4, btnA5, btnExit);

        Scene scene = new Scene(root, 280, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(160);
        button.setPrefHeight(32);
        button.setStyle(
                "-fx-background-color: black;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 5;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 2, 0, 0, 1);"
        );

        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #222222;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 5;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 3, 0, 0, 2);"
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: black;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 5;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 2, 0, 0, 1);"
        ));

        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}