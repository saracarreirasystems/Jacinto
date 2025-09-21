package org.example.A2;

public class Person {
    private String name;
    private String appearance;
    private String mood;

    public Person(String name, String appearance, String mood) {
        this.name = name;
        this.appearance = appearance;
        this.mood = mood;
    }

    public void interact() {
        System.out.println(name + " with " + appearance + " is feeling " + mood + " and is interacting.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}