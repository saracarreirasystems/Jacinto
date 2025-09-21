package org.example.A3B;

public class ArchitecturalElement {
    private String name;
    private String position;
    private String dimension;

    public ArchitecturalElement(String name, String position, String dimension) {
        this.name = name;
        this.position = position;
        this.dimension = dimension;
    }

    public void display() {
        System.out.println("This architectural element is called " + name + ", is located at " + position + ", and has dimensions " + dimension + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}