package org.example;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal("lion", 7000, 158);
        Building publicBuilding = new Building("Neoclassical", 20, 187);
        ArchitecturalElement fountain = new ArchitecturalElement("fountain", "center of the square", "8 meters in diameter");

        System.out.println("In Trafalgar Square, the imposing " + lion.getSpecies() + " statue stands beside a "
                + publicBuilding.getStyle() + " building, " + publicBuilding.getHeight() + " meters tall and " + publicBuilding.getAge() + " years old, accompanied by the architectural element " + fountain.getName() + " at the " + fountain.getPosition() + ", with a diameter of " + fountain.getDimension() + ".");
    }
}


