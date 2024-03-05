package animals.pets;

import animals.Animal;

public class Dog extends Animal {
    public Dog(int age, String name, int weight, String color) {
        super(age, name, weight, color);
    }
    public void say() {
        System.out.println("Гав!!!");
    }
}