package javaOOP;

public class Dog extends Animals implements AnimalsAbilities {
    public static void main(String[] args) {
        Dog dog = new Dog();

        // Ke Thua - Ingeritance
        dog.getAnimalName();

        // Da Hinh - Polymorphism
        dog.setAnimalName("Beo");

        dog.setAnimalName("Mer","Huyen");

    }

    @Override
    public void running()   {
        System.out.println("This Animal Running with 4 legs");
        System.out.println("==============================");
    }

    @Override
    public void eating()  {
        System.out.println("This Animal Eating within 30 mins");
        System.out.println("==============================");
    }
}
