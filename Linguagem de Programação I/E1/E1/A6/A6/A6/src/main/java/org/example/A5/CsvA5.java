package org.example.A5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvA5 {

    private static final String FILE_PATH = "A5.csv";

    public static void saveCharacter(Character character) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println("Character," + character.getName() + "," + character.getGender() + "," + character.getAppearance());
        } catch (IOException e) {
            System.out.println("Error saving character: " + e.getMessage());
        }
    }

    public static void saveEnvironment(Environment environment) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println("Environment," + environment.getLocation() + "," + environment.getTemperature() + "," + environment.getHazardLevel());
        } catch (IOException e) {
            System.out.println("Error saving environment: " + e.getMessage());
        }
    }

    public static void saveEvent(Event event) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println("Event," + event.getType() + "," + event.getIntensity() + "," + event.getOutcome());
        } catch (IOException e) {
            System.out.println("Error saving event: " + e.getMessage());
        }
    }
}