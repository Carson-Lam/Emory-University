//SUBMITTED BY: Carson Lam
//HELPED BY: Nobody
import java.util.Arrays;
import java.util.Stack;

public class QuickSorterWithFewerRecursiveCalls<Item extends Comparable<Item>> {

    Item[] a;

    private boolean less(Item v, Item w) {
        return (v.compareTo(w) < 0);
    }

    private void exch(int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int partition(int lo, int hi) {

        int i = lo;      // note, this will get incremented to (lo+1) before it is used
        int j = hi+1;    // similarly, this will get decremented to hi before it is used

        while (true) {

            while (less(a[++i], a[lo]))   //find position of item on left to swap
                if (i == hi) break;

            while (less(a[lo], a[--j]))   //find position of item on right to swap
                if (j == lo) break;

            if (i >= j) break;            //check if arrows (positions i and j) cross and we are
            //ready for final exchange

            exch(i, j);                   //swap the elements at positions i and j
        }

        exch(lo, j);     // final exchange (with pivot)

        return j;        // return index of item now known to be in place
    }

    public void sort1(Item[] a) {
        this.a = a;
        sort1(0,a.length-1);
    }

    private void sort1(int lo, int hi) {
        if (lo == hi) return;
        while (hi > lo) {
            int j = partition(lo, hi);
            if (lo<j-1) sort1(lo, j - 1);
            lo = j + 1;
        }
    }

    public void sort2(Item[] a) {
        this.a = a;
        sort2(0,a.length-1);
    }

    private void sort2(int lo, int hi) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(lo);
        s.push(hi);
        while(!s.isEmpty()){
            hi=s.pop();
            lo=s.pop();
            if(hi<=lo) continue;
            int j = partition(lo, hi);
            s.push(lo);
            s.push(j-1);
            s.push(j+1);
            s.push(hi);
        }
    }

    public static void main(String[] args) {
        Character[] a = {'K','R','A','T','E','L','E','P','U','I','M','Q','C','X','O','S'};
        Character[] b = {'K','R','A','T','E','L','E','P','U','I','M','Q','C','X','O','S'};
        QuickSorterWithFewerRecursiveCalls<Character> sorter = new QuickSorterWithFewerRecursiveCalls<Character>();
        sorter.sort1(a);
        System.out.println("Sorted (w/ 1 recursive call): " + Arrays.toString(a));
        sorter.sort2(b);
        System.out.println("Sorted (iterative quicksort): " + Arrays.toString(b));
    }
}
