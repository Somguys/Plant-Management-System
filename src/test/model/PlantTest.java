package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlantTest {
    Plant plant1;
    Plant plant2;
    Plant plant3;
    // creating plants to be tested
    @BeforeEach
    public void runBefore() {
        plant1 = new Plant("Lilly");
        plant2 = new Plant("Dandelion");
        plant3 = new Plant("Tulip");
    }
    // test constructor fields
    @Test
    void testConstructor() {
        assertEquals("Lilly", plant1.returnName());
        assertEquals(100, plant1.getPlantHealth());

    }
    // test both true and false cases for checkAlive()
    @Test
    void checkAlive() {
        assertTrue(plant1.checkAlive());

        for (int i = 0; i < 100; i++) {
            plant1.neglectPlant();
        }
        assertFalse(plant1.checkAlive());
    }
    // test both true and false cases for waterPlant()
    @Test
    void waterPlant() {
        assertTrue(plant1.waterPlant());
        for (int i = 0; i < 100; i++) {
            plant1.neglectPlant();
        }
        assertFalse(plant1.waterPlant());
    }

    @Test
    void waterPlant2() {
        assertTrue(plant1.waterPlant());
        plant1.neglectPlant();
        plant1.neglectPlant();
        plant1.neglectPlant();
        plant1.waterPlant();

        assertEquals(97,plant1.getPlantHealth());
    }


    // test both true and false cases for neglectPlant
    @Test
    void neglectPlant() {
        assertTrue(plant1.neglectPlant());

        for (int i = 0; i < 100; i++) {
            plant1.neglectPlant();
        }
        assertFalse(plant1.neglectPlant());

    }
    //  test the correct values are assigned to plantHealth after calling neglectPLant
    @Test
    void neglectPlant2() {
        assertTrue(plant2.neglectPlant()); // called once -2
        plant2.neglectPlant();      // called again -2
        assertEquals(96,plant2.getPlantHealth());
    }
}
