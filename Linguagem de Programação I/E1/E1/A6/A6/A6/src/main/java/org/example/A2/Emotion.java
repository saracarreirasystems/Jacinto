package org.example.A2;

public class Emotion {
    private String type;
    private int intensity;
    private int duration;

    public Emotion(String type, int intensity, int duration) {
        this.type = type;
        this.intensity = intensity;
        this.duration = duration;
    }

    public void express() {
        System.out.println("Expressing " + type + " with intensity " + intensity + " for " + duration + " seconds.");
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}