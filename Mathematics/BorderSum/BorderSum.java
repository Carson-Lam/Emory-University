package BorderSum;
import java.math.*;
import java.util.*;
public class BorderSum {
    public static void main(String[] args) {
        Random rand = new Random();
        int no1, no2, no3, no4, no5, no6, no7, no8, no9;
        no1 = (rand.nextInt(10));
        no2 = (rand.nextInt(10));
        no3 = (rand.nextInt(10));
        no4 = (rand.nextInt(10));
        no5 = (rand.nextInt(10));
        no6 = (rand.nextInt(10));
        no7 = (rand.nextInt(10));
        no8 = (rand.nextInt(10));
        no9 = (rand.nextInt(10));
        System.out.println((no1)+"----------"+(no2)+"----------"+(no3));
        System.out.println("|          |          |");
        System.out.println((no4)+"----------"+(no5)+"----------"+(no6));
        System.out.println("|          |          |");
        System.out.println((no7)+"----------"+(no8)+"----------"+(no9));
        System.out.println();
        System.out.println("Sum of columns:\n"+ "Column 1: "+(no1+no4+no7)+"\n"+"Column 2: "+(no2+no5+no8)+"\n"+"Column 3: "+(no3+no6+no9));
        System.out.println();
        System.out.println("Sum of rows:\n"+"Row 1: "+(no1+no2+no3)+"\n"+"Row 2: "+(no4+no5+no6)+"\n"+"Row 3: "+(no7+no8+no9));
        System.out.println();
        System.out.println("Sum of all numbers: "+((no1)+(no2)+(no3)+(no4)+(no5)+(no6)+(no7)+(no8)+(no9)));

        if ((no2+no5+no8)>10) {
            System.out.println("\nThe sum of the second column is: "
                    + (no2+no5+no8) + ", " + (no2+no5+no8) + " is > 10");
        } else {
            System.out.println("\nThe sum of the second column is: "
                    + (no2+no5+no8) + "," + (no2+no5+no8) + " is < 10");
        }

        if ((no1 % 2 == 0) || (no2 % 2 == 0) || (no3 % 2 == 0) || (no4 % 2 == 0) || (no5 % 2 == 0) || (no6 % 2 == 0) || (no7 % 2 == 0) || (no8 % 2 == 0) || (no9 % 2 == 0)){
            System.out.println("\nThere is an even number among 9 numbers");
        } else {
            System.out.println("\nThere is no even number");
        }

        if (((no4%2!=0)&&(no5%2!=0))||((no5%2!=0)&&(no6%2!=0))||((no4%2!=0)&&(no6%2!=0))){
            System.out.println("\nThere are not at least 2 odd numbers in middle row.");
        } else {
            System.out.println("\nThere are none");
        }
    }
}
