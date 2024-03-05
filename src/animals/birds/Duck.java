package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFly {
    public Duck(int age, String name, int weight, String color) {
        super(age, name, weight, color);
    }
    public void fly(){
        System.out.println("Я лечу");
    }
    public void say(){System.out.println("Кря-Кря");}
    public void go() {
        System.out.println("Я все еще лечу");
    }
}
