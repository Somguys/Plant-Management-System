package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StagingTest {
    Staging stagingPoint;
    Plant plant1;
    Plant plant2;
    Plant plant3;

    @BeforeEach
    public void runBefore() {
        stagingPoint = new Staging();
        plant1 = new Plant("Lilly");
        plant2 = new Plant("Dandelion");
        plant3 = new Plant("Tulip");

        stagingPoint.addPlant(plant1);
        stagingPoint.addPlant(plant2);
        stagingPoint.addPlant(plant3);

    }
    // testing correct plant is taken out of arraylist
    @Test
    void getPlantOfIndex() {
        assertEquals(plant1, stagingPoint.getPlantOfIndex(0));
    }
    // test the correct return of arraylist
    @Test
    void display() {
        ArrayList<Plant> testDisplay;
        testDisplay = new ArrayList<>();
        testDisplay.add(plant1);
        testDisplay.add(plant2);
        testDisplay.add(plant3);

        assertEquals(testDisplay, stagingPoint.display());
    }
}
