package AreaCalculator;
import java.util.*;
import java.math.*;
public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println("Geometry Calculator");
        int choice=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1. Calculate the area of a Circle\n" +
                    "2. Calculate the area of a Rectangle\n" +
                    "3. Calculate the area of a Right Triangle\n" +
                    "4. Calculate the area of a Trapezoid\n" +
                    "5. Quit\n");
            System.out.print("Enter your choice (1-5): "  );
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter radius: ");
                    double radius = sc.nextDouble();
                    System.out.printf("\nThe area of a circle with a radius of " + radius + " is " + "%.2f", (Math.PI * radius * radius));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\nEnter width and length: ");
                    double width = sc.nextDouble();
                    double length = sc.nextDouble();
                    System.out.printf("\nThe area of a rectangle with width of " + width +
                            " and length of " + length + " is " + "%.2f",(width*length));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\nEnter base and height: ");
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    System.out.printf("\nThe area of a right triangle with base of " + base +
                            " and height of " + height + " is " + "%.2f",(0.5*(base*height)));
                    System.out.println();
                    break;
                case 4:
                    System.out.print("\nEnter top, bottom, and height: ");
                    double top = sc.nextDouble();
                    double bottom = sc.nextDouble();
                    double heightTrap = sc.nextDouble();
                    System.out.printf("\nThe area of a trapezoid with top of " + top +
                            ", bottom of " + bottom  + ", and height of " + heightTrap +
                            " is " + "%.2f",((0.5*(top+bottom))*heightTrap));
                    System.out.println();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nPlease input a choice from 1-5");
            }
        } while (choice != 5);
        System.out.println("Thank you for using the geometry calculator");
    }
}
