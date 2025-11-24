package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.DAO.EmotionDAO;
import org.example.DAO.MemoryDAO;
import org.example.DAO.PersonDAO;
import org.example.Database.ClearDatabase;

import java.util.List;

public class AppA2 {

    public static void open(Stage stage) {

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

        Scene scene = new Scene(tabPane, 600, 450);
        stage.setScene(scene);
        stage.setTitle("E2 - Banco de Dados");
        stage.show();
    }

    // -------------------- PERSON UI --------------------
    private static VBox personUI() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField appearanceField = new TextField();
        appearanceField.setPromptText("Appearance");

        TextField moodField = new TextField();
        moodField.setPromptText("Mood");

        Button saveButton = new Button("Salvar Person");
        Button deleteButton = new Button("Apagar Banco");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        saveButton.setOnAction(e -> {
            Person person = new Person(
                    nameField.getText(),
                    appearanceField.getText(),
                    moodField.getText()
            );
            new PersonDAO().insert(person);
            refreshPersons(outputArea);
        });

        deleteButton.setOnAction(e -> {
            ClearDatabase.clearAll();
            outputArea.clear();
        });

        root.getChildren().addAll(nameField, appearanceField, moodField, saveButton, deleteButton, outputArea);
        return root;
    }

    // -------------------- MEMORY UI --------------------
    private static VBox memoryUI() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField contentField = new TextField();
        contentField.setPromptText("Content");

        TextField impactField = new TextField();
        impactField.setPromptText("Impact");

        TextField recurrenceField = new TextField();
        recurrenceField.setPromptText("Recurrence");

        Button saveButton = new Button("Salvar Memory");
        Button deleteButton = new Button("Apagar Banco");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        saveButton.setOnAction(e -> {
            Memory memory = new Memory(
                    contentField.getText(),
                    Integer.parseInt(impactField.getText()),
                    Integer.parseInt(recurrenceField.getText())
            );
            new MemoryDAO().insert(memory);
            refreshMemories(outputArea);
        });

        deleteButton.setOnAction(e -> {
            ClearDatabase.clearAll();
            outputArea.clear();
        });

        root.getChildren().addAll(contentField, impactField, recurrenceField, saveButton, deleteButton, outputArea);
        return root;
    }

    // -------------------- EMOTION UI --------------------
    private static VBox emotionUI() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        TextField typeField = new TextField();
        typeField.setPromptText("Type");

        TextField intensityField = new TextField();
        intensityField.setPromptText("Intensity");

        TextField durationField = new TextField();
        durationField.setPromptText("Duration");

        Button saveButton = new Button("Salvar Emotion");
        Button deleteButton = new Button("Apagar Banco");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        saveButton.setOnAction(e -> {
            Emotion emotion = new Emotion(
                    typeField.getText(),
                    Integer.parseInt(intensityField.getText()),
                    Integer.parseInt(durationField.getText())
            );
            new EmotionDAO().insert(emotion);
            refreshEmotions(outputArea);
        });

        deleteButton.setOnAction(e -> {
            ClearDatabase.clearAll();
            outputArea.clear();
        });

        root.getChildren().addAll(typeField, intensityField, durationField, saveButton, deleteButton, outputArea);
        return root;
    }

    // -------------------- REFRESH METHODS --------------------
    private static void refreshPersons(TextArea area) {
        area.clear();
        List<Person> list = new PersonDAO().getAll();
        for (Person p : list) {
            area.appendText(
                    p.getName() + " | Aparência: " + p.getAppearance() + " | Humor: " + p.getMood() + "\n"
            );
        }
    }

    private static void refreshMemories(TextArea area) {
        area.clear();
        List<Memory> list = new MemoryDAO().getAll();
        for (Memory m : list) {
            area.appendText(
                    m.getContent() + " | Impacto: " + m.getImpact() + " | Recorrência: " + m.getRecurrence() + "\n"
            );
        }
    }

    private static void refreshEmotions(TextArea area) {
        area.clear();
        List<Emotion> list = new EmotionDAO().getAll();
        for (Emotion em : list) {
            area.appendText(
                    em.getType() + " | Intensidade: " + em.getIntensity() + " | Duração: " + em.getDuration() + "\n"
            );
        }
    }
}