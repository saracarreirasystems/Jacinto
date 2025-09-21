package org.example.A3A;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvA3A {

    private static final String FILE_NAME = "A3A.csv";

    public static void saveAnimal(Animal animal) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(animal.getSpecies() + "," + animal.getWeight() + "," + animal.getAge());
        } catch (IOException e) {
            System.out.println("Error saving Animal: " + e.getMessage());
        }
    }

    public static void saveMaterial(Material material) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(material.getComposition() + "," + material.getTexture() + "," + material.getDensity());
        } catch (IOException e) {
            System.out.println("Error saving Material: " + e.getMessage());
        }
    }

    public static void saveTrace(Trace trace) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(trace.getShape() + "," + trace.getDepth() + "," + trace.getOrigin());
        } catch (IOException e) {
            System.out.println("Error saving Trace: " + e.getMessage());
        }
    }
}