package org.example.A4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppA4 {

    public static void open(Stage stage) {
        VBox root = new VBox(18);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Label title = new Label("A4 - Classes & CSV Registration");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnAnimal = createButton("Register Animal");
        Button btnBuilding = createButton("Register Building");
        Button btnElement = createButton("Register Element");
        Button btnBack = createButton("Exit");

        btnAnimal.setOnAction(e -> openAnimalStage());
        btnBuilding.setOnAction(e -> openBuildingStage());
        btnElement.setOnAction(e -> openElementStage());
        btnBack.setOnAction(e -> stage.close());

        root.getChildren().addAll(title, btnAnimal, btnBuilding, btnElement, btnBack);

        Scene scene = new Scene(root, 350, 280);
        stage.setScene(scene);
        stage.setTitle("A4");
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
                CsvA4.saveAnimal(new Animal(
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

    private static void openBuildingStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtStyle = new TextField();
        TextField txtHeight = new TextField();
        TextField txtAge = new TextField();
        Button btnSave = createButton("Save Building");
        Label feedback = new Label();

        grid.add(new Label("Style:"), 0, 0);
        grid.add(txtStyle, 1, 0);
        grid.add(new Label("Height:"), 0, 1);
        grid.add(txtHeight, 1, 1);
        grid.add(new Label("Age:"), 0, 2);
        grid.add(txtAge, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                CsvA4.saveBuilding(new Building(
                        txtStyle.getText(),
                        Integer.parseInt(txtHeight.getText()),
                        Integer.parseInt(txtAge.getText())
                ));
                feedback.setText("Building saved successfully!");
            } catch (NumberFormatException ex) {
                feedback.setText("Height and Age must be numbers!");
            }
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Building");
        stage.show();
    }

    private static void openElementStage() {
        Stage stage = new Stage();
        GridPane grid = createFormGrid();

        TextField txtName = new TextField();
        TextField txtPosition = new TextField();
        TextField txtDimension = new TextField();
        Button btnSave = createButton("Save Element");
        Label feedback = new Label();

        grid.add(new Label("Name:"), 0, 0);
        grid.add(txtName, 1, 0);
        grid.add(new Label("Position:"), 0, 1);
        grid.add(txtPosition, 1, 1);
        grid.add(new Label("Dimension:"), 0, 2);
        grid.add(txtDimension, 1, 2);
        grid.add(btnSave, 1, 3);
        grid.add(feedback, 1, 4);

        btnSave.setOnAction(e -> {
            CsvA4.saveArchitecturalElement(new ArchitecturalElement(
                    txtName.getText(),
                    txtPosition.getText(),
                    txtDimension.getText()
            ));
            feedback.setText("Architectural Element saved successfully!");
        });

        stage.setScene(new Scene(grid, 400, 300));
        stage.setTitle("Register Architectural Element");
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