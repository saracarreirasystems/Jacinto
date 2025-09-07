package org.example;

public class Main {
    public static void main(String[] args) {
        Animal rhino = new Animal("Rhinoceros", 2300, 12);
        Material soil = new Material("Soil", "granular texture", 1.5);
        Trace contourLines = new Trace("contour lines", 0.2, "artist's manipulation");

        System.out.println("In this Vik Muniz artwork, " + rhino.getSpecies() + " is depicted using " + soil.getComposition() + ", with visible " + contourLines.getShape() + " from " + contourLines.getOrigin() + ".");
    }
}