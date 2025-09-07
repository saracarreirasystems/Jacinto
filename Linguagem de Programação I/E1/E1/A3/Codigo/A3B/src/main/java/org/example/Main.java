package org.example;

public class Main {
    public static void main(String[] args) {
        Building castle = new Building("Renaissance", 56, 506);
        Material sand = new Material("Sand", 1, "grain");
        ArchitecturalElement tower = new ArchitecturalElement("Main Tower", "center of the castle", "30 meters high");

        System.out.println("In this Vik Muniz artwork, the " + castle.getStyle() + " castle is depicted using " + sand.getType() + " with grain size " + sand.getGrainSize() + " and color " + sand.getColor() + ", including the architectural element " + tower.getName() + " located at " + tower.getPosition() + " with dimensions " + tower.getDimension() + ".");
    }
}

