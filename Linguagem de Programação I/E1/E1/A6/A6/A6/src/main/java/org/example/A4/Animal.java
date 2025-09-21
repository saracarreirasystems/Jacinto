package org.example.A4;

public class Animal {
    private String species;
    private int weight;
    private int age;

    public Animal(String species, int weight, int age) {
        this.species = species;
        this.weight = weight;
        this.age = age;
    }

    public void move() {
        System.out.println(species + " is moving.");
    }

    public void pose() {
        System.out.println(species + " is posing.");
    }

    public void makeSound() {
        System.out.println(species + " is making a sound.");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}