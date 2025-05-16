package javaOOP;

public class Animals {

    String animalName = "Beo's Dog";

    // Dong Goi - Encapsulation
    protected void getAnimalName() {
        System.out.println("This Animal current Name is: " + animalName);
        System.out.println("==============================");
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
        System.out.println("Animal New Name is: " + this.animalName);
        System.out.println("==============================");
    }

    protected void setAnimalName(String animalName, String ownerName) {
        this.animalName = animalName;
        System.out.println(this.animalName + " belongs to " + ownerName);
        System.out.println("==============================");
    }

}
