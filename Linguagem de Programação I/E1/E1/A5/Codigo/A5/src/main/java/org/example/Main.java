package org.example;

public class Main {
    public static void main(String[] args) {
        Character miner1 = new Character("Miner 1", "male", "lean and determined");
        Character miner2 = new Character("Miner 2", "male", "strong and rugged");

        Environment mountainMine = new Environment("mountain mine", -20, 8);

        Event betrayal = new Event("betrayal", 5, "Miner 1 survives, carrying the weight of losing his companion");

        System.out.println("In the icy and treacherous mountain mine, "
                + miner1.getName() + ", with a lean and determined appearance, and " + miner2.getName() + ", with a strong and rugged appearance, work side by side, sharing the burden of their labor. " + "The harsh environment, with a temperature of " + mountainMine.getTemperature() + " degrees and hazard level " + mountainMine.getHazardLevel() + ", makes every step a challenge. " + "Suddenly, the shadow of betrayal rises with intensity " + betrayal.getIntensity() + ", and fate unfolds: " + betrayal.getOutcome() + ".");
    }
}