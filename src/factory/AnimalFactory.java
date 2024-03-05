package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;

public class AnimalFactory {

    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color;
    public AnimalFactory(int age, String name, int weight, String color) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.color = color;

    }


    public Animal create(AnimalData animalData) {
        switch (animalData) {
            case CAT:
                return new Cat(this.age, this.name, this.weight, this.color);
            case DOG:
                return new Dog(this.age, this.name, this.weight, this.color);
            default:
                return new Duck(this.age, this.name, this.weight, this.color);
        }
    }
}
