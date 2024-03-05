package validators;

public class WeightValidator {
    public boolean isValidate(String weightStr){
        NumberValidator numberValidator = new NumberValidator();
        if (!numberValidator.isNumber(weightStr)) {
            System.out.println("Вес должен быть числом");
            return false;
        }

        int animalWeight = Integer.parseInt(weightStr);

        if(animalWeight <=0) {
            System.out.println("Вес должен быть > 0");
            return false;
        }

        return true;
    }
}


