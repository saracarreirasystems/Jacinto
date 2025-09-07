package org.example;

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
        System.out.println(name + " is being displayed.");
    }

    public void move() {
        System.out.println(name + " is moving from " + position + ".");
    }

    public void resize() {
        System.out.println(name + " has been resized to " + dimension + ".");
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