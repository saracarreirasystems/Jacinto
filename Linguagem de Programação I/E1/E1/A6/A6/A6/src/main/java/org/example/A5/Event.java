package org.example.A5;

public class Event {
    private String type;
    private int intensity;
    private String outcome;

    public Event(String type, int intensity, String outcome) {
        this.type = type;
        this.intensity = intensity;
        this.outcome = outcome;
    }

    public void trigger() {
        System.out.println("The " + type + " event has started.");
    }

    public void evaluateImpact() {
        System.out.println("Evaluating the impact of the " + type + " event with intensity " + intensity + ".");
    }

    public void displayOutcome() {
        System.out.println("The outcome of the " + type + " event is: " + outcome + ".");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}