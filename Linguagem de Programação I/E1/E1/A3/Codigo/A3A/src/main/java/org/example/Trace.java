package org.example;

public class Trace {
    private String shape;
    private double depth;
    private String origin;

    public Trace(String shape, double depth, String origin) {
        this.shape = shape;
        this.depth = depth;
        this.origin = origin;
    }

    public void examine() {
        System.out.println("This trace has a " + shape + " shape, a depth of " + depth + " cm, and originates from " + origin + ".");
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}