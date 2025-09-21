package org.example.A3A;

public class Animal {
    private String species;
    private int weight;
    private int age;

    public Animal(String species, int weight, int age) {
        this.species = species;
        this.weight = weight;
        this.age = age;
    }

    public void describe() {
        System.out.println("This fossil is of a " + species + ", weighs " + weight + ", and is " + age + " years old.");
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