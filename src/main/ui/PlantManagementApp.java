package ui;


import model.*;

import java.util.ArrayList;
import java.util.Scanner;


import java.util.Timer;
import java.util.TimerTask;

public class PlantManagementApp {
    private Garden garden1;
    private Staging staging;

    // EFFECTS: runs the teller application
    public PlantManagementApp() {
        runGarden();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGarden() {
        boolean keepGoing = true;
        String command;

        garden1 = new Garden();
        staging = new Staging();

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");

        while (keepGoing) {
            decayPlantGarden();
            decayPlantStaging();
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }


        System.out.println("\nGoodbye!");
    }



    private void processCommand(String command) {
        switch (command) {
            case "c":
                createPlant();
                break;
            case "d":
                display();
                break;
            case "dd":
                displayGarden();
                break;
            case "a":
                addPlant();
                break;
            case "r":
                removePlant();
                break;
            case "w":
                waterPlant();
                break;
            default:
                System.out.println("Selection not valid...");
                break;
        }
    }

    private void displayMenu() {
        System.out.println("\nWhat would you like to do:");
        System.out.println("\nPlants can only be watered in the garden");
        System.out.println("\nYou better place your plants in the garden fast, or they will start dying!! :((");
        System.out.println("\tc  -> create plant");
        System.out.println("\td  -> display list of created plants");
        System.out.println("\tdd  -> display list plants in garden");
        System.out.println("\ta  -> add plant to garden");
        System.out.println("\tr -> remove plant from garden");
        System.out.println("\tw -> water plant");
        System.out.println("\tq -> quit");
    }


    private void createPlant() {
        System.out.println("What would you like to name your plant");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        Plant created = new Plant(name);
        staging.addPlant(created);
    }

    private void removePlant() {
        System.out.println("which plant would you like to remove, enter integer of positon starting from zero");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        garden1.removePlant(index);
    }

    private void display() {
        ArrayList<Plant> plantList = staging.display();
        for (int i = 0; i < plantList.size(); i++) {
            Plant displaying = plantList.get(i);
            displaying.checkAlive();
            if (!displaying.checkAlive()) {
                System.out.println("Sadly your plant " + displaying.name + " has died due to neglect");
            } else {
                System.out.println("You plant " + displaying.name + " is still alive but you "
                        +
                        "need to remember to care for it, health: " + displaying.getPlantHealth() + ".");
            }
            System.out.println("position: " + i);
        }
    }

    private void displayGarden() {
        ArrayList<Plant> plantList = garden1.display();
        for (int i = 0; i < plantList.size(); i++) {
            Plant displaying = plantList.get(i);
            displaying.checkAlive();
            if (!displaying.checkAlive()) {
                System.out.println("Sadly your plant " + displaying.name + " has died due to neglect");
            } else {
                System.out.println("You plant " + displaying.name + " is still alive but you "
                        +
                        "need to remember to care for it, health: " + displaying.getPlantHealth() + ".");
            }
            System.out.println("position: " + i);
        }
    }

    private void addPlant() {
        System.out.println("Which plant would you like to add, type integer from staging starting with position 0");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        Plant add = staging.getPlantOfIndex(index);
        garden1.addPlant(add);
        staging.display().remove(add);
    }

    private void waterPlant() {
        System.out.println("You can only water plants in your garden, "
                +
                "which plant do you want to water, "
                +
                "enter integer number representing position in garden starting from zero");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        Plant waterPlant = garden1.getPlant(index);
        waterPlant.waterPlant();
        if (waterPlant.waterPlant()) {
            System.out.println("Watering plant");
            System.out.println(waterPlant.name + ", Health:  " + waterPlant.getPlantHealth());
        } else {
            System.out.println("Sadly your  plant " + waterPlant.name + " has died due to neglect");
        }
    }

    // run decay (neglectPlant()) method for plants in garden, slower due to longer time run between period
    private void decayPlantGarden() {
        ArrayList<Plant> gardenList = garden1.display();

        for (Plant plant : gardenList) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    plant.neglectPlant();
                }
            }, 0, 160000);
        }
    }

    // run decay method for plants in staging, faster decay time due to function running faster
    private void decayPlantStaging() {
        ArrayList<Plant> stagingList = staging.display();
        for (Plant plant : stagingList) {
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    plant.neglectPlant();
                }
            }, 0, 80000);
        }
    }

}
