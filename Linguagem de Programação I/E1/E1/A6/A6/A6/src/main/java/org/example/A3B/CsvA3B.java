package org.example.A3B;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvA3B {

    private static final String FILE_NAME = "A3B.csv";

    public static void saveBuilding(Building building) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(building.getStyle() + "," + building.getHeight() + "," + building.getAge());
        } catch (IOException e) {
            System.out.println("Error saving building: " + e.getMessage());
        }
    }

    public static void saveMaterial(Material material) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(material.getType() + "," + material.getGrainSize() + "," + material.getColor());
        } catch (IOException e) {
            System.out.println("Error saving material: " + e.getMessage());
        }
    }

    public static void saveArchitecturalElement(ArchitecturalElement element) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            pw.println(element.getName() + "," + element.getPosition() + "," + element.getDimension());
        } catch (IOException e) {
            System.out.println("Error saving architectural element: " + e.getMessage());
        }
    }
}