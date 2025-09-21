package org.example.A5;

public class Environment {
    private String location;
    private int temperature;
    private int hazardLevel;

    public Environment(String location, int temperature, int hazardLevel) {
        this.location = location;
        this.temperature = temperature;
        this.hazardLevel = hazardLevel;
    }

    public void describe() {
        System.out.println("The environment is located at " + location + " with a temperature of " + temperature + " degrees and a hazard level of " + hazardLevel + ".");
    }

    public void change() {
        System.out.println("The environment is gradually changing over time.");
    }

    public void affect() {
        System.out.println("The environment is affecting the characters in its own way.");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHazardLevel() {
        return hazardLevel;
    }

    public void setHazardLevel(int hazardLevel) {
        this.hazardLevel = hazardLevel;
    }
}