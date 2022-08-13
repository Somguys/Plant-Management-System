package model;

//creates class object plant
// plant has feature such as name and plant health


public class Plant {
    private static final int DECAY_RATE = 2;
    private static final int REGEN_RATE = 3;
    // name of plant

    public final String name;
    // from 0 to 100
    private int plantHealth;
    // from 0 to 10
    private int plantStage;
    // whether plant is alive
    private boolean alive;

    // type will implement later on, using interface or other


    // constructor for plant, initializing fields
    public Plant(String a) {
        this.name = a;
        this.plantHealth = 100;
        // this.plantStage = 0;
        this.alive = true;
    }


    // MODIFIES: this
    // EFFECTS: decreases the int plantHealth by int DECAY RATE and returns true, else returns false
    public boolean neglectPlant() {
        if (plantHealth > 0 && alive) {
            plantHealth -= DECAY_RATE;
            return true;
        } else {
            alive = false;
            System.out.println("Plant " + name + " has died :( ");
            return false;
        }
    }



    // MODIFIES: this
    // EFFECTS: adds int value of REGEN RATE to int plantHealth and returns true, else returns false
    public boolean waterPlant() {
        if (!alive) {
            return false;
        } else if (plantHealth <= 97) {
            plantHealth = plantHealth + REGEN_RATE;
        }
        return true;
    }

    // EFFECTS: returns boolean value to check if plant is alive
    public boolean checkAlive() {
        return alive;
    }

    public String returnName() {
        return name;
    }

    public int getPlantHealth() {
        return plantHealth;
    }


}
