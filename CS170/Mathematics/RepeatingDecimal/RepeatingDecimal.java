package RepeatingDecimal;
import java.util.Scanner;

public class RepeatingDecimal {

    public static String fractionAsDecimal(int numerator, int denominator) {
        int remainder = numerator % denominator;
        int start = 0;
        int end = 0;
        int counter = 0;
        int[] remainders = new int[denominator];
        //Making this denominator-1 means that the array is
        //out of bounds for 3/2 since the array of remainders becomes 1
        boolean isRepeating = false;
        String s = "";
        String output = "";
        s += ((int) (numerator / denominator));
        if (remainder != 0) { // didn't go in evenly
            s += (".");
            counter++;
            remainders[remainder] = counter;
            while (!isRepeating) {
                remainder *= 10;

                int quotient = (remainder / denominator);
                if (remainder % denominator == 0) {
                    s += quotient;
                    break;
                } else {
                    s += quotient;
                }
                remainder %= denominator;
                counter++;
                if (remainders[remainder] == 0) {// you haven't yet seen this remainder
                    remainders[remainder] = counter;
                } else {
                    start = remainders[remainder];
                    end = counter;
//                    System.out.println();
//                    System.out.println("Start:" + start); //START +2
//                    System.out.println("End:" + end); //END +2
                    isRepeating = true;

                }
            }
        }
        if (isRepeating) {
            String integerPart = s.substring(0, s.indexOf(".") + 1);
            String decimalPart = s.substring(s.indexOf(".") + 1);
            String nonRepeating = decimalPart.substring(0, start - 1);
            String repeating = decimalPart.substring(start - 1);
            String linedDigits = "";
            for (int i = 0; i < repeating.length(); i++) {
                linedDigits += repeating.charAt(i) + "\u0305";
            }
            output += integerPart + nonRepeating + linedDigits;
            return output;
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter some number of fractions of positive integers (separated by spaces).");
        System.out.println("Long division will then be used to find their (exact) decimal forms.");
        // example input:
        // 8/2 3/2 1/8 1/7 101/3 1/6 1/12 970/23 1691/330 3179893/9906

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        String[] quotients = line.split(" ");
        for (String quotient : quotients) {
            String[] parts = quotient.split("/");
            int num = Integer.parseInt(parts[0]);
            int denom = Integer.parseInt(parts[1]);
            System.out.println("" + num + "/" + denom + " = " + fractionAsDecimal(num,denom));
        }
    }
}