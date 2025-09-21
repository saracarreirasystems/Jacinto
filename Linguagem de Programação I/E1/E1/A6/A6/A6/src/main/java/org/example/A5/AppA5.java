package org.example.A5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppA5 {

    public static void open(Stage stage) {
        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("A5 - Classes & CSV Registration");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnCharacter = createButton("Register Character");
        Button btnEnvironment = createButton("Register Environment");
        Button btnEvent = createButton("Register Event");
        Button btnBack = createButton("Exit");

        btnCharacter.setOnAction(e -> openCharacterStage());
        btnEnvironment.setOnAction(e -> openEnvironmentStage());
        btnEvent.setOnAction(e -> openEventStage());
        btnBack.setOnAction(e -> stage.close());

        root.getChildren().addAll(title, btnCharacter, btnEnvironment, btnEvent, btnBack);

        Scene scene = new Scene(root, 350, 280);
        stage.setScene(scene);
        stage.setTitle("A5");
        stage.show();
    }

    private static void openCharacterStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtName = new TextField();
        TextField txtGender = new TextField();
        TextField txtAppearance = new TextField();
        Button btnSave = createButton("Save Character");
        Label feedback = new Label();

        grid.add(new Label("Name:"), 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(new Label("Gender:"), 0, 1);
        grid.add(txtGender, 1, 1);
        grid.add(new Label("Appearance:"), 0, 2);
        grid.add(txtAppearance, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            CsvA5.saveCharacter(new Character(
                    txtName.getText(),
                    txtGender.getText(),
                    txtAppearance.getText()
            ));
            feedback.setText("Character saved successfully!");
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Character");
        stage.show();
    }

    private static void openEnvironmentStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtLocation = new TextField();
        TextField txtTemperature = new TextField();
        TextField txtHazardLevel = new TextField();
        Button btnSave = createButton("Save Environment");
        Label feedback = new Label();

        grid.add(new Label("Location:"), 0, 0);
        grid.add(txtLocation, 1, 0);
        grid.add(new Label("Temperature:"), 0, 1);
        grid.add(txtTemperature, 1, 1);
        grid.add(new Label("Hazard Level:"), 0, 2);
        grid.add(txtHazardLevel, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA5.saveEnvironment(new Environment(
                        txtLocation.getText(),
                        Integer.parseInt(txtTemperature.getText()),
                        Integer.parseInt(txtHazardLevel.getText())
                ));
                feedback.setText("Environment saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Temperature and Hazard Level must be numbers!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Environment");
        stage.show();
    }

    private static void openEventStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtType = new TextField();
        TextField txtIntensity = new TextField();
        TextField txtOutcome = new TextField();
        Button btnSave = createButton("Save Event");
        Label feedback = new Label();

        grid.add(new Label("Type:"), 0, 0);
        grid.add(txtType, 1, 0);
        grid.add(new Label("Intensity:"), 0, 1);
        grid.add(txtIntensity, 1, 1);
        grid.add(new Label("Outcome:"), 0, 2);
        grid.add(txtOutcome, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA5.saveEvent(new Event(
                        txtType.getText(),
                        Integer.parseInt(txtIntensity.getText()),
                        txtOutcome.getText()
                ));
                feedback.setText("Event saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Intensity must be a number!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Event");
        stage.show();
    }

    private static GridPane createFormGrid() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: white;");
        return grid;
    }

    private static Button createButton(String text) {
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
}