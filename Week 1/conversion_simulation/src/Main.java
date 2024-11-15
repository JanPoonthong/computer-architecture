import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(binaryToDecimal("1101"));
    }

    public static StringBuilder decimalToBinary(int number) {
        if (number == 0) {
            return new StringBuilder("0");
        }
        StringBuilder binaryRepresentation = new StringBuilder();

        while (number != 0) {
            int remainder = number % 2;
            binaryRepresentation.append(remainder);
            number = number / 2;
        }

        return binaryRepresentation.reverse();
    }

    public static double binaryToDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            throw new IllegalArgumentException("Binary number cannot be null or empty");
        }

        double decimal = 0;
        int length = binaryNumber.length() - 1;
        for (int index = 0; index != binaryNumber.length(); index++) {
            char digit = binaryNumber.charAt(index);
            if (digit != '0' && digit != '1') {
                throw new IllegalArgumentException("Invalid character in binary number: " + digit);
            }

            if (digit == '1') {
                decimal += 1 * Math.pow(2, length-index);
            }
        }
        return decimal;
    }
}