package org.example.A2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppA2 {

    public static void open(Stage stage) {
        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("A2 - Classes & CSV Registration");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnPerson = createButton("Register Person");
        Button btnMemory = createButton("Register Memory");
        Button btnEmotion = createButton("Register Emotion");
        Button btnBack = createButton("Exit");

        btnPerson.setOnAction(e -> openPersonStage());
        btnMemory.setOnAction(e -> openMemoryStage());
        btnEmotion.setOnAction(e -> openEmotionStage());
        btnBack.setOnAction(e -> stage.close());

        root.getChildren().addAll(title, btnPerson, btnMemory, btnEmotion, btnBack);

        Scene scene = new Scene(root, 350, 280);
        stage.setScene(scene);
        stage.setTitle("A2");
        stage.show();
    }

    private static void openPersonStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtName = new TextField();
        TextField txtAppearance = new TextField();
        TextField txtMood = new TextField();
        Button btnSave = createButton("Save Person");
        Label feedback = new Label();

        grid.add(new Label("Name:"), 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(new Label("Appearance:"), 0, 1);
        grid.add(txtAppearance, 1, 1);
        grid.add(new Label("Mood:"), 0, 2);
        grid.add(txtMood, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            CsvA2.savePerson(new Person(txtName.getText(), txtAppearance.getText(), txtMood.getText()));
            feedback.setText("Person saved successfully!");
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Person");
        stage.show();
    }

    private static void openMemoryStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtContent = new TextField();
        TextField txtImpact = new TextField();
        TextField txtRecurrence = new TextField();
        Button btnSave = createButton("Save Memory");
        Label feedback = new Label();

        grid.add(new Label("Content:"), 0, 0);
        grid.add(txtContent, 1, 0);
        grid.add(new Label("Impact:"), 0, 1);
        grid.add(txtImpact, 1, 1);
        grid.add(new Label("Recurrence:"), 0, 2);
        grid.add(txtRecurrence, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA2.saveMemory(new Memory(txtContent.getText(),
                        Integer.parseInt(txtImpact.getText()),
                        Integer.parseInt(txtRecurrence.getText())));
                feedback.setText("Memory saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Impact and Recurrence must be numbers!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Memory");
        stage.show();
    }

    private static void openEmotionStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtType = new TextField();
        TextField txtIntensity = new TextField();
        TextField txtDuration = new TextField();
        Button btnSave = createButton("Save Emotion");
        Label feedback = new Label();

        grid.add(new Label("Type:"), 0, 0);
        grid.add(txtType, 1, 0);
        grid.add(new Label("Intensity:"), 0, 1);
        grid.add(txtIntensity, 1, 1);
        grid.add(new Label("Duration:"), 0, 2);
        grid.add(txtDuration, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA2.saveEmotion(new Emotion(txtType.getText(),
                        Integer.parseInt(txtIntensity.getText()),
                        Integer.parseInt(txtDuration.getText())));
                feedback.setText("Emotion saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Intensity and Duration must be numbers!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Emotion");
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