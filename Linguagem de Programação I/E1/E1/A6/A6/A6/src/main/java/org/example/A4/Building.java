package org.example.A4;

public class Building {
    private String style;
    private int height;
    private int age;

    public Building(String style, int height, int age) {
        this.style = style;
        this.height = height;
        this.age = age;
    }

    public void describe() {
        System.out.println("This building has a " + style + " style, is " + height + " meters tall, and is " + age + " years old.");
    }

    public void renovate() {
        System.out.println("The building has been renovated.");
    }

    public void checkHeight() {
        System.out.println("The building's height is " + height + " meters.");
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}