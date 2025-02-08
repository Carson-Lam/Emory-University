import java.util.*;
import java.lang.*;
public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Please input a string");
        String input = sc.nextLine();
        String reverse = "";
        String upper = "";
        String lower = "";
        String numbers = "";
        for (int i = 0; i<input.length();i++) {
            if (Character.isUpperCase(input.charAt(i))){
                upper += input.charAt(i);
            }
            if (Character.isLowerCase(input.charAt(i))){
                lower += input.charAt(i);
            }
            if (Character.isDigit(input.charAt(i))){
                numbers += input.charAt(i);
            }
        }
        for (int j = input.length()-1; j>=0;j--){
            reverse += input.charAt(j);
        }
        System.out.println("The reverse string is:");
        System.out.println(reverse);
        System.out.println("Upper case letters in the string are:");
        System.out.println(upper);
        System.out.println("Lower case letters in the string are:");
        System.out.println(lower);
        System.out.println("Numbers in the string are:");
        System.out.println(numbers);
    }
}

