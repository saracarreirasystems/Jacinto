package org.example.A4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvA4 {

    private static final String FILE_PATH = "A4.csv";

    public static void saveAnimal(Animal animal) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println(animal.getSpecies() + "," + animal.getWeight() + "," + animal.getAge());
        } catch (IOException e) {
            System.out.println("Error saving Animal: " + e.getMessage());
        }
    }

    public static void saveBuilding(Building building) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println(building.getStyle() + "," + building.getHeight() + "," + building.getAge());
        } catch (IOException e) {
            System.out.println("Error saving Building: " + e.getMessage());
        }
    }

    public static void saveArchitecturalElement(ArchitecturalElement element) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            pw.println(element.getName() + "," + element.getPosition() + "," + element.getDimension());
        } catch (IOException e) {
            System.out.println("Error saving Architectural Element: " + e.getMessage());
        }
    }
}