package QuadraticSolver;
import java.io.PrintStream;
import java.util.Scanner;

public class QuadraticSolver {
   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter coefficient a of quadratic equation: ");
      double var2 = (double)var1.nextInt();
      System.out.print("Enter coefficient b of quadratic equation: ");
      double var4 = (double)var1.nextInt();
      System.out.print("Enter coefficient c of quadratic equation: ");
      double var6 = (double)var1.nextInt();
      if (var2 == 0.0) {
         System.out.println("This is not a quadratic equation: a == 0");
      } else if (Math.pow(var4, 2.0) - 4.0 * var2 * var6 < 0.0) {
         System.out.println("This equation has no real solutions");
      } else {
         System.out.println("The equation is " + var2 + "x^2 + " + var4 + "x + " + var6 + " = 0");
         PrintStream var10000 = System.out;
         double var10001 = (-var4 + Math.sqrt(Math.pow(var4, 2.0) - 4.0 * var2 * var6)) / (2.0 * var2);
         var10000.println("The solutions are: " + var10001 + ", " + (-var4 - Math.sqrt(Math.pow(var4, 2.0) - 4.0 * var2 * var6)) / (2.0 * var2));
      }

   }
}
