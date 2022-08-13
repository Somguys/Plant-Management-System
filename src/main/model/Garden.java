package model;

import java.util.ArrayList;
// Class of Garden which contains methods and arraylist to hold plants

public class Garden {
    // maximum size of garden
    public static final int MAX_SIZE = 12;

    private static ArrayList<Plant> myGarden;

    public Garden() {
        myGarden = new ArrayList<>();
    }

    // REQUIRES: plant object
    // MODIFIES: this
    // EFFECTS: adds plant to arraylist myGarden
    public void addPlant(Plant a) {
        if (myGarden.size() < MAX_SIZE) {
            myGarden.add(a);
        }
    }

    // REQUIRES: int >= 0 , within range of arraylist
    // MODIFIES: this
    // EFFECTS: removes plant from arraylist myGarden
    public void removePlant(int b) {
        myGarden.remove(myGarden.get(b));
    }


    // EFFECTS: returns arraylist of plants
    public ArrayList<Plant> display() {
        return myGarden;
    }

    // REQUIRES: int >= 0 , within range of arraylist
    // EFFECTS: adds plant to arraylist myGarden
    public Plant getPlant(int i) {
        return myGarden.get(i);
    }
}

