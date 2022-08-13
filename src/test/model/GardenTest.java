package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GardenTest {
    Garden myGarden;
    Plant plant1;
    Plant plant2;
    Plant plant3;
    Plant plant4;

    @BeforeEach
    public void runBefore() {
        myGarden = new Garden();
        plant1 = new Plant("Lilly");
        plant2 = new Plant("Dandelion");
        plant3 = new Plant("Tulip");
        plant4 = new Plant("Daisy");
        myGarden.addPlant(plant1);
        myGarden.addPlant(plant2);
        myGarden.addPlant(plant3);

    }
    // test returning correct plant
    @Test
    void getPlant() {
        assertEquals(plant1, myGarden.getPlant(0));

    }
    // testing correctly adding plant and then validating with assertEquals
    @Test
    void addPlant() {
        myGarden.addPlant(plant4);
        assertEquals(plant4, myGarden.getPlant(3));
    }
    // testing the correct removal of plant and then validating with assertEquals
    @Test
    void removePlant() {
        myGarden.removePlant(0);
        assertEquals(plant2, myGarden.getPlant(0));
    }
    // test the correct return of arraylist
    @Test
    void display(){
        ArrayList<Plant> testDisplay ;
        testDisplay = new ArrayList<>();
        testDisplay.add(plant1);
        testDisplay.add(plant2);
        testDisplay.add(plant3);

        assertEquals(testDisplay,myGarden.display());
    }


}
