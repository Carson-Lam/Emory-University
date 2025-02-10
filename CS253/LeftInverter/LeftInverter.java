/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Carson Lam
 */
import java.io.*;
import java.util.StringTokenizer;
public class LeftInverter {

    public static int[] computeL(int[] A) {
        int N = A.length;

        int[] L = new int[N];        // output array
        int[] indices = new int[N];  // indices
        int[] aux = new int[N];      // aux array

        // Initialize indices array [0,1,2,...,N-1]
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }

        // Sort indices based on values in A
        sort(indices, aux, A, 0, N-1, L);

        return L;
    }

    private static void sort(int[] indices, int[] aux, int[] A, int lo, int hi, int[] L) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(indices, aux, A, lo, mid, L);
        sort(indices, aux, A, mid + 1, hi, L);
        merge(indices, aux, A, lo, mid, hi, L);
    }
    private static void merge(int[] indices, int[] aux, int[] A, int lo, int mid, int hi, int[] L) {
        long inversions = 0;

        for (int k = lo; k <= hi; k++) {
            aux[k] = indices[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           indices[k] = aux[j++];
            else if (j > hi)            indices[k] = aux[i++];
            else if (A[aux[j]] < A[aux[i]]) {
                indices[k] = aux[j++];
                L[aux[j]] += (mid - i + 1);
            }
            else                        indices[k] = aux[i++];
        }
    }

    // This main() handles the input and output in a fast buffered way, you DO NOT need to modify main().
    public static void main(String[] args) throws IOException {

        // Read input array A. We avoid java.util.Scanner, for speed.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // first line
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); // second line

        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(st.nextToken());

        // Solve the problem!
        int[] L = computeL(A);

        // Print the output array L.
        PrintWriter out = new PrintWriter(System.out);

        out.print(L[0]);

        for (int i = 1; i < N; ++i)
            out.print(" " + L[i]);
        out.close();
    }
}