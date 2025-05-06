package LongestPS;
import java.util.Scanner;
public class LongPS {
    public static void main(String args[]) throws Exception {

        // Read input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        assert N == S.length();

        // Compute answer
        String P;
        if (N <= 5000) {
            P = solveDP(S);
        } else {
            P = solveGreedy(S);
        }

        // Print answer
        System.out.println(P.length());
        System.out.println(P);
    }

    // solve(s) returns the longest palindrome subsequence in string s.
    // This is recursive, and runs in worst-case exponential time.
    // Remark: there are other ways to do this recursively!
    static String solveDP(String s) {
        int n = s.length();
        int[][] L = new int[n][n];

        for(int len = 1; len <= n; len++){
            for(int i = 0;i<=n-len;i++){
                int j = i+len-1;
                if (len == 1) {
                    L[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        L[i][j] = 2;
                    } else {
                        L[i][j] = L[i + 1][j - 1] + 2;
                    }
                } else {
//                    if (L[i+1][j] >= L[i][j-1]) {
//                        L[i][j] = L[i+1][j];
//                    } else {
//                        L[i][j] = L[i][j-1];
//                    }
                    L[i][j] = Math.max(L[i+1][j], L[i][j-1]);
                }
            }
        }

        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();
        int i = 0, j = n-1;
        while (i<=j){
            if (s.charAt(i) == s.charAt(j)) {
                if  (i == j){
                    firstHalf.append(s.charAt(i));
                } else {
                    firstHalf.append(s.charAt(i));
                    secondHalf.append(s.charAt(j));
                }
                i++;
                j--;
            } else if (L[i+1][j] > L[i][j-1]) {
                i++;
            } else {
                j--;
            }
        }
        secondHalf.reverse();
        return firstHalf.toString() + secondHalf.toString();
    }
    static String solveGreedy(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (i == j) {
                    firstHalf.append(s.charAt(i));
                } else {
                    firstHalf.append(s.charAt(i));
                    secondHalf.append(s.charAt(j));
                }
                i++;
                j--;
            } else {
                if (s.charAt(i) == s.charAt(j - 1)) {
                    j--;
                } else if (s.charAt(i + 1) == s.charAt(j)) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        secondHalf.reverse();
        return firstHalf.toString() + secondHalf.toString();
    }
}