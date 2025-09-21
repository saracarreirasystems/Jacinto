package org.example.A3A;

public class Material {
    private String composition;
    private String texture;
    private double density;

    public Material(String composition, String texture, double density) {
        this.composition = composition;
        this.texture = texture;
        this.density = density;
    }

    public void analyze() {
        System.out.println("This material is composed of " + composition + ", has a " + texture + " texture, and a density of " + density + ".");
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }
}