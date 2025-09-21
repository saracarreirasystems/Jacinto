package org.example.A3B;

public class Material {
    private String type;
    private int grainSize;
    private String color;

    public Material(String type, int grainSize, String color) {
        this.type = type;
        this.grainSize = grainSize;
        this.color = color;
    }

    public void analyze() {
        System.out.println("This material is of type " + type + ", has a grain size of " + grainSize + ", and is " + color + " in color.");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGrainSize() {
        return grainSize;
    }

    public void setGrainSize(int grainSize) {
        this.grainSize = grainSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}