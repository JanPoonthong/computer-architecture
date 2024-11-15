import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(decimalToHexadecimal(14));
        System.out.println(binaryToHexadecimal("10110111"));
        System.out.println(hexadecimalToDecimal("23E"));
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

    public static String decimalToHexadecimal(int number) {
        if (number == 0) return "0";
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexString = new StringBuilder();

        while (number > 0) {
            int remainder = number % 16;
            hexString.append(hexDigits[remainder]);
            number = number / 16;
        }

        return hexString.reverse().toString();
    }

    public static String binaryToHexadecimal(String binary) {
        int decimal = (int) binaryToDecimal(binary);
        return decimalToHexadecimal(decimal);
    }

    public static double hexadecimalToDecimal(String hexadecimal) {
        if (hexadecimal == null || hexadecimal.isEmpty()) {
            throw new IllegalArgumentException("Binary number cannot be null or empty");
        }

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        double decimal = 0;
        int length = hexadecimal.length() - 1;
        for (int index = 0; index != hexadecimal.length(); index++) {
            char digit = hexadecimal.charAt(index);
            int value = -1;
            for (int i = 0; i < hexDigits.length; i++) {
                if (hexDigits[i] == digit) {
                    value = i;
                    break;
                }
            }
            if (value != -1) {
                decimal += value * Math.pow(16, length-index);
            } else {
                throw new IllegalArgumentException("Invalid character in binary number: " + digit);
            }
        }
        return decimal;
    }
}