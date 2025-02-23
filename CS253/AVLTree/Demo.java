// RETRIEVED FROM: Michael T. Goodrich and Roberto Tamassia. 2014. Algorithm Design and Applications (1st. ed.). Wiley Publishing.
// A simple interactive test of AVLTree<Integer> where the input is just a sequence of integers.

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Demo
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc;
	// If there is a command line argument, then scan tokens from
	// the named file, otherwise scan from the standard input.
	if (args.length > 0)
	    sc = new Scanner(new File(args[0]));
	else
	    sc = new Scanner(System.in);

        BST<Integer> t = new AVLTree<Integer>();
        System.out.println("AVLTree t is empty, enter a sequence of integers:");
        System.out.println("  enter positive integer  K to do t.insert(K)");
        System.out.println("  enter negative integer -K to do t.remove(K)");
        System.out.println("  enter 0 to do t.printTree() and t.testAVL()");
        System.out.println("  anything else to quit");
        while (true) {
            if (!sc.hasNextInt()) break;
            int k = sc.nextInt();
            if (k==0) {
                t.printTree();
                String msg = t.testAVL();
                if (msg != null)
                    System.out.println("t.testAVL() reports: " + msg);
                else
                    System.out.println("t.testAVL() found no problems");
            } else if (k > 0) {
                System.out.println("t.insert("+k+") returns " + t.insert(k));
                if (t.find(k)==null)
                    System.out.println("BUG: t.find("+k+") is null");
            } else { // k < 0
                k = -k;
                System.out.println("t.remove("+k+") returns " + t.remove(k));
                if (t.find(k)!=null)
                    System.out.println("BUG: t.find("+k+") is not null");
            }
        }
    }
}
