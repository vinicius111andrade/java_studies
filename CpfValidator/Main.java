package CpfValidator;

public class Main {
    public static void main(String[] args) {

        int[] testNumbers = {1, 2, 3, 4, 5, 7, 7, 8, 9, 5, 4};

        boolean isValid = CpfValidator.isCpfValid(testNumbers);
        System.out.println("The CPF is valid? " + isValid);
    }
}

