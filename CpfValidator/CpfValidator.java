import java.util.Scanner;

public class CpfValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um CPF (apenas números): ");
        String cpf = scanner.nextLine();

        if (isCpfValid(cpf)) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }

       scanner.close();
    }

    public static boolean isCpfValid(int[] cpf) {

        if(!cpfHasCorrectLength(cpf) || cpfHasRepeatedNumberOnly(cpf)) {
            return false;
        }

        boolean isCpfValid = cpfHasCorrectVerifierDigits(
            calculateCpfFirstVerifierDigit(cpf),
            calculateCpfSecondVerifierDigit(cpf),
            cpf
        );

        return isCpfValid;
    }

    public static boolean isCpfValid(String cpf) {
        int[] digits = buildIntArrayFromString(cpf);

        return isCpfValid(digits);
    }

    private static int[] buildIntArrayFromString(String string) {
        int length = string.length();
        int[] intArray = new int[length];
        int index = 0;

        while(index < length) {
            intArray[index] = Character.getNumericValue(string.charAt(index));
            index++;
        }

        return intArray;
    }

    private static boolean cpfHasCorrectLength(int[] cpf) {
        return cpf.length == 11;
    }

    private static boolean cpfHasRepeatedNumberOnly(int[] cpf) {
        int first = cpf[0];
        int index = 0;

        while(index < cpf.length) {
            if(first != cpf[index]) {
                return false;
            }
            index++;
        }

        return true;
    }

    private static int calculateCpfFirstVerifierDigit(int[] cpf) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += cpf[i] * (10 - i);
        }

        int remainder = sum % 11;
        int firstVerifierDigit = (remainder < 2) ? 0 : 11 - remainder;

        return firstVerifierDigit;
    }

    private static int calculateCpfSecondVerifierDigit(int[] cpf) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cpf[i] * (11 - i);
        }

        int remainder = sum % 11;
        int secondVerifierDigit = (remainder < 2) ? 0 : 11 - remainder;

        return secondVerifierDigit;
    }

    private static boolean cpfHasCorrectVerifierDigits(
        int firstDigit,
        int secondDigit,
        int[] cpf) {
        return cpf[9] == firstDigit && cpf[10] == secondDigit;
    }

}
