package animals;

public abstract class Animal {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color = null;

    public Animal(int age, String name, int weight, String color) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.color = color;

    }

    public void say(){
        System.out.println("Я говорю");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void drink(){
        System.out.println("Я пью");
    }
    public void eat(){
        System.out.println("Я ем");
    }

    @Override
    public String toString() {

        String yearPadeg = getYearPadej();
        if(yearPadeg == null){
            return "Возраст введен неверно";
        }

        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                this.name,
                this.age,
                yearPadeg,
                this.weight,
                this.color
        );
    }
    private String getYearPadej() {

        if(this.age <=0 || this.age > 50){
            return null;
        }
        if(this.age >= 11 && this.age <=19){
            return "лет";
        }
        int ostatok = this.age % 10;
        if(ostatok == 0 || ostatok >=5) {
            return "лет";
        }

        if(ostatok ==1) {
            return "год";
        }
        if(ostatok >=2) {
            return "года";
        }
        return "года";
    }
}
