package org.example.A3A;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppA3A {

    public static void open(Stage stage) {
        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("A3A - Classes & CSV Registration");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnAnimal = createButton("Register Animal");
        Button btnMaterial = createButton("Register Material");
        Button btnTrace = createButton("Register Trace");
        Button btnExit = createButton("Exit");

        btnAnimal.setOnAction(e -> openAnimalStage());
        btnMaterial.setOnAction(e -> openMaterialStage());
        btnTrace.setOnAction(e -> openTraceStage());
        btnExit.setOnAction(e -> stage.close());

        root.getChildren().addAll(title, btnAnimal, btnMaterial, btnTrace, btnExit);

        Scene scene = new Scene(root, 350, 280);
        stage.setScene(scene);
        stage.setTitle("A3A");
        stage.show();
    }

    private static void openAnimalStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtSpecies = new TextField();
        TextField txtWeight = new TextField();
        TextField txtAge = new TextField();
        Button btnSave = createButton("Save Animal");
        Label feedback = new Label();

        grid.add(new Label("Species:"), 0, 0);
        grid.add(txtSpecies, 1, 0);
        grid.add(new Label("Weight:"), 0, 1);
        grid.add(txtWeight, 1, 1);
        grid.add(new Label("Age:"), 0, 2);
        grid.add(txtAge, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA3A.saveAnimal(new Animal(
                        txtSpecies.getText(),
                        Integer.parseInt(txtWeight.getText()),
                        Integer.parseInt(txtAge.getText())
                ));
                feedback.setText("Animal saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Weight and Age must be numbers!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Animal");
        stage.show();
    }

    private static void openMaterialStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtComposition = new TextField();
        TextField txtTexture = new TextField();
        TextField txtDensity = new TextField();
        Button btnSave = createButton("Save Material");
        Label feedback = new Label();

        grid.add(new Label("Composition:"), 0, 0);
        grid.add(txtComposition, 1, 0);
        grid.add(new Label("Texture:"), 0, 1);
        grid.add(txtTexture, 1, 1);
        grid.add(new Label("Density:"), 0, 2);
        grid.add(txtDensity, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA3A.saveMaterial(new Material(
                        txtComposition.getText(),
                        txtTexture.getText(),
                        Double.parseDouble(txtDensity.getText())
                ));
                feedback.setText("Material saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Density must be a number!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Material");
        stage.show();
    }

    private static void openTraceStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtShape = new TextField();
        TextField txtDepth = new TextField();
        TextField txtOrigin = new TextField();
        Button btnSave = createButton("Save Trace");
        Label feedback = new Label();

        grid.add(new Label("Shape:"), 0, 0);
        grid.add(txtShape, 1, 0);
        grid.add(new Label("Depth:"), 0, 1);
        grid.add(txtDepth, 1, 1);
        grid.add(new Label("Origin:"), 0, 2);
        grid.add(txtOrigin, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA3A.saveTrace(new Trace(
                        txtShape.getText(),
                        Double.parseDouble(txtDepth.getText()),
                        txtOrigin.getText()
                ));
                feedback.setText("Trace saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Depth must be a number!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Trace");
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