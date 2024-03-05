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
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        DataValidator commandValidator = new DataValidator();
        NumberValidator numberValidator = new NumberValidator();
        AgeValidator ageValidator = new AgeValidator();
        WeightValidator weightValidator = new WeightValidator();


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
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного cat/dog/duck:");
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (!commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            System.out.println("Вы ввели неверный тип");
                            continue;
                        }
                        break;
                    }

                    System.out.println("Введите имя животного:");
                    String name = scanner.next();

                    int animalAge = -1;
                    while(true){
                        System.out.println("Введите возраст животного:");
                        String ageStr = scanner.next();
                        if(!ageValidator.isValidate(ageStr)){
                            continue;
                        };
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

                    System.out.println("Введите цвет животного:");
                    String color = scanner.next();


                    AnimalFactory animalFactory = new AnimalFactory(animalAge, name, animalWeight, color);
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