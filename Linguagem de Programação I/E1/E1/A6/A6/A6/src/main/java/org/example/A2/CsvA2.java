package org.example.A2;

import java.io.FileWriter;
import java.io.IOException;

public class CsvA2 {
    private static final String FILE = "A2.csv";

    public static void savePerson(Person p) {
        try (FileWriter writer = new FileWriter(FILE, true)) {
            writer.append("Person,")
                    .append(p.getName()).append(",")
                    .append(p.getAppearance()).append(",")
                    .append(p.getMood())
                    .append(",,,,\n");
        } catch (IOException e) {
            System.out.println("Error saving Person to CSV: " + e.getMessage());
        }
    }

    public static void saveMemory(Memory m) {
        try (FileWriter writer = new FileWriter(FILE, true)) {
            writer.append("Memory,,,")
                    .append(m.getContent()).append(",")
                    .append(String.valueOf(m.getImpact())).append(",")
                    .append(String.valueOf(m.getRecurrence()))
                    .append(",,\n");
        } catch (IOException e) {
            System.out.println("Error saving Memory to CSV: " + e.getMessage());
        }
    }

    public static void saveEmotion(Emotion em) {
        try (FileWriter writer = new FileWriter(FILE, true)) {
            writer.append("Emotion,,,,,,")
                    .append(em.getType()).append(",")
                    .append(String.valueOf(em.getIntensity())).append(",")
                    .append(String.valueOf(em.getDuration()))
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error saving Emotion to CSV: " + e.getMessage());
        }
    }
}