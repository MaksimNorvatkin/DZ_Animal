import animals.Animal;
import animals.birds.IFly;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.AgeValidator;
import validators.DataValidator;
import validators.NumberValidator;
import validators.WeightValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        DataValidator commandValidator = new DataValidator();
        AgeValidator ageValidator = new AgeValidator();
        WeightValidator weightValidator = new WeightValidator();
        NumberValidator numberValidator = new NumberValidator();


        while (true){
            System.out.println("Введите команду add/list/exit:");
            String commandStr = scanner.next().toUpperCase().trim();

            if (!commandValidator.isValidate(commandStr, CommandsData.values())){
                System.out.println("Вы ввели неверную команду");
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD:
                    String animalTypeStr ="";
                    while (true) {
                        System.out.println("Введите тип животного cat/dog/duck:");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (!commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            System.out.println("Вы ввели неверный тип");
                            continue;
                        }
                        break;
                    }

                    String nameStr ="";
                    while (true) {
                        System.out.println("Введите имя животного:");
                        nameStr = scanner.next();
                        if (numberValidator.isNumber(nameStr)) {
                            System.out.println("Имя не должено быть числом");
                            continue;
                        }
                        break;
                    }

                    int animalAge = -1;
                    while(true){
                        System.out.println("Введите возраст животного:");
                        String ageStr = scanner.next();
                        if(!ageValidator.isValidate(ageStr)){
                            continue;
                        }
                        animalAge = Integer.parseInt(ageStr);
                        break;
                    }

                    int animalWeight = -1;
                    while(true){
                        System.out.println("Введите вес животного:");
                        String weightStr = scanner.next();
                        if(!weightValidator.isValidate(weightStr)) {
                            continue;
                        }
                        animalWeight = Integer.parseInt(weightStr);
                        break;
                    }

                    String colorStr = "";
                    while (true) {
                        System.out.println("Введите цвет животного:");
                        colorStr = scanner.next();
                        if (numberValidator.isNumber(colorStr)) {
                            System.out.println("Цвет не должео быть числом");
                            continue;
                        }
                        break;

                    }

                    AnimalFactory animalFactory = new AnimalFactory(animalAge, nameStr, animalWeight, colorStr);
                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                    animalList.add(animal);

                    animal.say();
                    if (animal instanceof IFly) {
                        ((IFly) animal).fly();
                    }
                    animal.go();
                    animal.drink();
                    animal.eat();

                case LIST:
                    for(Animal animalObj: animalList){
                        System.out.println(animalObj.toString());
                    }

                    if(animalList.isEmpty()){
                        System.out.println("Я пустой!");
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}