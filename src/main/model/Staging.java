package model;

import java.util.ArrayList;

// Class of Staging which contains methods and arraylist to hold plants when they are created, purpoes is to
// keep plants in one place before they are moved to garden

public class Staging {
    private static ArrayList<Plant> staged;


    public Staging() {
        // arraylist of plant type to hold plants

        staged = new ArrayList<>();
    }

    // REQUIRES: plant object
    // MODIFIES: this
    // EFFECTS: adds plant to arraylist staged
    public void addPlant(Plant a) {
        staged.add(a);
    }

    // EFFECTS: returns arraylist of plants
    public ArrayList<Plant> display() {
        return staged;
    }

    // REQUIRES:positive integer from 0 to arraylist end bound
    // MODIFIES: this
    // EFFECTS: return plant of given index
    public Plant getPlantOfIndex(int i) {
        return staged.get(i);
    }
}
