import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(12));
    }

    public static StringBuilder decimalToBinary(int number) {
        List<Integer> binaryDigits = new ArrayList<>();

        while (true) {
            int remainder = number % 2;
            binaryDigits.add(remainder);
            number = number / 2;
            if (remainder == 1) {
                binaryDigits.add(number);
                break;
            };
        }

        StringBuilder binaryString = new StringBuilder();
        for (int digit: binaryDigits) {
            binaryString.append(digit);
        }

        return binaryString.reverse();
    }
}