package org.example.A5;

public class Character {
    private String name;
    private String gender;
    private String appearance;

    public Character(String name, String gender, String appearance) {
        this.name = name;
        this.gender = gender;
        this.appearance = appearance;
    }

    public void performAction() {
        System.out.println(name + " is performing an action in the story.");
    }

    public void changeAppearance() {
        System.out.println(name + "'s appearance has changed to " + appearance + ".");
    }

    public void interact() {
        System.out.println(name + " is interacting with other characters.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }
}