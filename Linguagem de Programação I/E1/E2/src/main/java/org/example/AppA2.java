package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.example.Database.Database;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppA2 {

    public static void open(Stage stage) {

        // Garante que as tabelas existem
        Database.initialize();

        TabPane tabPane = new TabPane();

        Tab tabPerson = new Tab("Person");
        tabPerson.setContent(personUI());
        tabPerson.setClosable(false);

        Tab tabMemory = new Tab("Memory");
        tabMemory.setContent(memoryUI());
        tabMemory.setClosable(false);

        Tab tabEmotion = new Tab("Emotion");
        tabEmotion.setContent(emotionUI());
        tabEmotion.setClosable(false);

        tabPane.getTabs().addAll(tabPerson, tabMemory, tabEmotion);

        Scene scene = new Scene(tabPane, 700, 500);
        stage.setScene(scene);
        stage.setTitle("E2 - Banco de Dados");
        stage.show();
    }

    // -------------------- PERSON UI --------------------
    private static VBox personUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField idField = new TextField();
        idField.setPromptText("ID (para atualizar)");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField appearanceField = new TextField();
        appearanceField.setPromptText("Appearance");

        TextField moodField = new TextField();
        moodField.setPromptText("Mood");

        Button saveButton = new Button("Salvar Person");
        Button updateButton = new Button("Atualizar Person");
        Button clearButton = new Button("Apagar Banco (todas as tabelas)");

        HBox buttons = new HBox(10, saveButton, updateButton, clearButton);
        buttons.setAlignment(Pos.CENTER);

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // INSERIR
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String appearance = appearanceField.getText();
            String mood = moodField.getText();

            if (name.isEmpty() && appearance.isEmpty() && mood.isEmpty()) {
                showAlert("Campos vazios", "Preencha pelo menos um campo para salvar.");
                return;
            }

            int id = Database.insertPerson(name, appearance, mood);
            if (id == -1) {
                showAlert("Erro", "Não foi possível salvar a pessoa.");
            } else {
                nameField.clear();
                appearanceField.clear();
                moodField.clear();
                refreshPersons(outputArea);
            }
        });

        // ATUALIZAR
        updateButton.setOnAction(e -> {
            String idText = idField.getText();
            if (idText.isEmpty()) {
                showAlert("ID obrigatório", "Informe o ID da pessoa que deseja atualizar.");
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException ex) {
                showAlert("ID inválido", "O ID deve ser um número inteiro.");
                return;
            }

            String name = nameField.getText();
            String appearance = appearanceField.getText();
            String mood = moodField.getText();

            if (name.isEmpty() && appearance.isEmpty() && mood.isEmpty()) {
                showAlert("Campos vazios", "Preencha ao menos um campo com o novo conteúdo.");
                return;
            }

            // Para simplificar, vamos atualizar usando os 3 campos.
            boolean ok = Database.updatePerson(id, name, appearance, mood);
            if (!ok) {
                showAlert("Erro", "Não foi possível atualizar a pessoa. Verifique se o ID existe.");
            } else {
                refreshPersons(outputArea);
            }
        });

        // APAGAR TODAS
        clearButton.setOnAction(e -> {
            clearAllTables();
            outputArea.clear();
        });

        root.getChildren().addAll(
                idField,
                nameField,
                appearanceField,
                moodField,
                buttons,
                outputArea
        );

        // Carrega dados ao abrir a aba
        refreshPersons(outputArea);

        return root;
    }

    // -------------------- MEMORY UI --------------------
    private static VBox memoryUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField idField = new TextField();
        idField.setPromptText("ID (para atualizar)");

        TextField contentField = new TextField();
        contentField.setPromptText("Content");

        TextField impactField = new TextField();
        impactField.setPromptText("Impact (número)");

        TextField recurrenceField = new TextField();
        recurrenceField.setPromptText("Recurrence (número)");

        Button saveButton = new Button("Salvar Memory");
        Button updateButton = new Button("Atualizar Memory");
        Button clearButton = new Button("Apagar Banco (todas as tabelas)");

        HBox buttons = new HBox(10, saveButton, updateButton, clearButton);
        buttons.setAlignment(Pos.CENTER);

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // INSERIR
        saveButton.setOnAction(e -> {
            String content = contentField.getText();
            String impactText = impactField.getText();
            String recurrenceText = recurrenceField.getText();

            if (content.isEmpty() || impactText.isEmpty() || recurrenceText.isEmpty()) {
                showAlert("Campos vazios", "Preencha todos os campos para salvar a memória.");
                return;
            }

            int impact;
            int recurrence;
            try {
                impact = Integer.parseInt(impactText);
                recurrence = Integer.parseInt(recurrenceText);
            } catch (NumberFormatException ex) {
                showAlert("Valor inválido", "Impact e Recurrence precisam ser números inteiros.");
                return;
            }

            int id = Database.insertMemory(content, impact, recurrence);
            if (id == -1) {
                showAlert("Erro", "Não foi possível salvar a memória.");
            } else {
                contentField.clear();
                impactField.clear();
                recurrenceField.clear();
                refreshMemories(outputArea);
            }
        });

        // ATUALIZAR
        updateButton.setOnAction(e -> {
            String idText = idField.getText();
            if (idText.isEmpty()) {
                showAlert("ID obrigatório", "Informe o ID da memória que deseja atualizar.");
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException ex) {
                showAlert("ID inválido", "O ID deve ser um número inteiro.");
                return;
            }

            String content = contentField.getText();
            String impactText = impactField.getText();
            String recurrenceText = recurrenceField.getText();

            if (content.isEmpty() || impactText.isEmpty() || recurrenceText.isEmpty()) {
                showAlert("Campos vazios", "Preencha todos os campos com os novos valores.");
                return;
            }

            int impact;
            int recurrence;
            try {
                impact = Integer.parseInt(impactText);
                recurrence = Integer.parseInt(recurrenceText);
            } catch (NumberFormatException ex) {
                showAlert("Valor inválido", "Impact e Recurrence precisam ser números inteiros.");
                return;
            }

            boolean ok = Database.updateMemory(id, content, impact, recurrence);
            if (!ok) {
                showAlert("Erro", "Não foi possível atualizar a memória. Verifique se o ID existe.");
            } else {
                refreshMemories(outputArea);
            }
        });

        // APAGAR TODAS
        clearButton.setOnAction(e -> {
            clearAllTables();
            outputArea.clear();
        });

        root.getChildren().addAll(
                idField,
                contentField,
                impactField,
                recurrenceField,
                buttons,
                outputArea
        );

        refreshMemories(outputArea);

        return root;
    }

    // -------------------- EMOTION UI --------------------
    private static VBox emotionUI() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField idField = new TextField();
        idField.setPromptText("ID (para atualizar)");

        TextField typeField = new TextField();
        typeField.setPromptText("Type");

        TextField intensityField = new TextField();
        intensityField.setPromptText("Intensity (número)");

        TextField durationField = new TextField();
        durationField.setPromptText("Duration (número)");

        Button saveButton = new Button("Salvar Emotion");
        Button updateButton = new Button("Atualizar Emotion");
        Button clearButton = new Button("Apagar Banco (todas as tabelas)");

        HBox buttons = new HBox(10, saveButton, updateButton, clearButton);
        buttons.setAlignment(Pos.CENTER);

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // INSERIR
        saveButton.setOnAction(e -> {
            String type = typeField.getText();
            String intensityText = intensityField.getText();
            String durationText = durationField.getText();

            if (type.isEmpty() || intensityText.isEmpty() || durationText.isEmpty()) {
                showAlert("Campos vazios", "Preencha todos os campos para salvar a emoção.");
                return;
            }

            int intensity;
            int duration;
            try {
                intensity = Integer.parseInt(intensityText);
                duration = Integer.parseInt(durationText);
            } catch (NumberFormatException ex) {
                showAlert("Valor inválido", "Intensity e Duration precisam ser números inteiros.");
                return;
            }

            int id = Database.insertEmotion(type, intensity, duration);
            if (id == -1) {
                showAlert("Erro", "Não foi possível salvar a emoção.");
            } else {
                typeField.clear();
                intensityField.clear();
                durationField.clear();
                refreshEmotions(outputArea);
            }
        });

        // ATUALIZAR
        updateButton.setOnAction(e -> {
            String idText = idField.getText();
            if (idText.isEmpty()) {
                showAlert("ID obrigatório", "Informe o ID da emoção que deseja atualizar.");
                return;
            }

            int id;
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException ex) {
                showAlert("ID inválido", "O ID deve ser um número inteiro.");
                return;
            }

            String type = typeField.getText();
            String intensityText = intensityField.getText();
            String durationText = durationField.getText();

            if (type.isEmpty() || intensityText.isEmpty() || durationText.isEmpty()) {
                showAlert("Campos vazios", "Preencha todos os campos com os novos valores.");
                return;
            }

            int intensity;
            int duration;
            try {
                intensity = Integer.parseInt(intensityText);
                duration = Integer.parseInt(durationText);
            } catch (NumberFormatException ex) {
                showAlert("Valor inválido", "Intensity e Duration precisam ser números inteiros.");
                return;
            }

            boolean ok = Database.updateEmotion(id, type, intensity, duration);
            if (!ok) {
                showAlert("Erro", "Não foi possível atualizar a emoção. Verifique se o ID existe.");
            } else {
                refreshEmotions(outputArea);
            }
        });

        // APAGAR TODAS
        clearButton.setOnAction(e -> {
            clearAllTables();
            outputArea.clear();
        });

        root.getChildren().addAll(
                idField,
                typeField,
                intensityField,
                durationField,
                buttons,
                outputArea
        );

        refreshEmotions(outputArea);

        return root;
    }

    // -------------------- REFRESH METHODS --------------------
    private static void refreshPersons(TextArea area) {
        area.clear();
        List<Map<String, Object>> list = Database.selectAllPersons();
        for (Map<String, Object> row : list) {
            int id = (Integer) row.get("id");
            String name = (String) row.get("name");
            String appearance = (String) row.get("appearance");
            String mood = (String) row.get("mood");

            area.appendText(
                    "ID: " + id +
                    " | Nome: " + name +
                    " | Aparência: " + appearance +
                    " | Humor: " + mood + "\n"
            );
        }
    }

    private static void refreshMemories(TextArea area) {
        area.clear();
        List<Map<String, Object>> list = Database.selectAllMemories();
        for (Map<String, Object> row : list) {
            int id = (Integer) row.get("id");
            String content = (String) row.get("content");
            int impact = (Integer) row.get("impact");
            int recurrence = (Integer) row.get("recurrence");

            area.appendText(
                    "ID: " + id +
                    " | Conteúdo: " + content +
                    " | Impacto: " + impact +
                    " | Recorrência: " + recurrence + "\n"
            );
        }
    }

    private static void refreshEmotions(TextArea area) {
        area.clear();
        List<Map<String, Object>> list = Database.selectAllEmotions();
        for (Map<String, Object> row : list) {
            int id = (Integer) row.get("id");
            String type = (String) row.get("type");
            int intensity = (Integer) row.get("intensity");
            int duration = (Integer) row.get("duration");

            area.appendText(
                    "ID: " + id +
                    " | Tipo: " + type +
                    " | Intensidade: " + intensity +
                    " | Duração: " + duration + "\n"
            );
        }
    }

    // -------------------- CLEAR ALL (todas as tabelas) --------------------
    private static void clearAllTables() {
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement()) {

            st.executeUpdate("DELETE FROM Person");
            st.executeUpdate("DELETE FROM Memory");
            st.executeUpdate("DELETE FROM Emotion");

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Erro", "Não foi possível apagar os dados do banco.");
        }
    }

    // -------------------- ALERT HELPER --------------------
    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
