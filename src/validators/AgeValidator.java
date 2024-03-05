package validators;

public class AgeValidator {
    public boolean isValidate(String ageStr){
        NumberValidator numberValidator = new NumberValidator();
        if (!numberValidator.isNumber(ageStr)) {
            System.out.println("Возраст должен быть числом");
            return false;
        }

        int animalAge = Integer.parseInt(ageStr);

        if(animalAge > 50 || animalAge <=0) {
            System.out.println("Возраст должен быть > 0 и меньше 50");
            return false;
        }

        return true;
    }
}
