package CpfValidator;

public class CpfValidator {

    static final int minimumCpfSize = 10;
    static final int maximumCpfSize = 11;

    public static boolean isCpfValid(int[] cpfArray) {

        if(!isCpfSizeCorrect(cpfArray)) {
            return false;
        } else if (!isFirstVerifierDigitCorrect(cpfArray)) {
            return false;
        }

        return true;
  }

    private static boolean isCpfSizeCorrect(int[] cpfArray) {
        int cpfSize = cpfArray.length;
        return cpfSize >= minimumCpfSize && cpfSize <= maximumCpfSize;
    }

    private static boolean isFirstVerifierDigitCorrect(int[] cpfArray) {

        int firstVerifierDigit = calculateFirstVerifierDigit(cpfArray);

        boolean isFirstDigitCorrect = firstVerifierDigit == cpfArray[9];

        return isFirstDigitCorrect;
    }

    private static int calculateFirstVerifierDigit(int[] cpfArray) {

        int sum = calculateCpfSpecialSum(cpfArray);
        int remainder = sum % 11;
        int firstVerifierDigit;

        if(remainder < 2) {
            firstVerifierDigit = 0;
        } else {
            firstVerifierDigit = 11 - remainder;
        }

        return firstVerifierDigit;
    }


    private static int calculateCpfSpecialSum(int[] cpfArray) {

        int[] weights = {10,9,8,7,6,5,4,3,2};

        int index = 0;
        int sum = 0;

        while(index < (weights.length - 1)) {
            sum += cpfArray[index] * weights[index];
        }

        return sum;
    }

}