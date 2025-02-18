//SUBMITTED BY: Carson Lam
//HELPED BY: Noah Huff
package twoways;

public class TailRecursionToIteration {

    ProblemSpecAndTools psat;

    public TailRecursionToIteration(ProblemSpecAndTools psat) {
        this.psat = psat;
    }

    public Object findRecursively() {
        if (psat.isBaseCase()) {
            psat.updateAccumulatorBaseCase();
            return psat.accumulator();
        } else {
            psat.updateAccumulatorNonBaseCase();
            psat.reduceProblem();
            return findRecursively();
        }
    }

    public Object findIteratively() {
        while (!psat.isBaseCase()) {
            psat.updateAccumulatorNonBaseCase();
            psat.reduceProblem();
        }
        psat.updateAccumulatorBaseCase();
        return psat.accumulator();
    }

    public static class FactorialPSAT implements ProblemSpecAndTools {
        private int n;
        private int a; //accumulator

        public FactorialPSAT(int n) {
            this.n = n;
            this.a = 1;
        }

        public boolean isBaseCase() {
            return n == 0;
        }

        public void reduceProblem() {
            n--;
        }

        public void updateAccumulatorBaseCase() {
            // do nothing
        }

        public void updateAccumulatorNonBaseCase() {
            a = n * a;
        }

        public String toString() {
            return "" + a;
        }

        public Object accumulator() {
            return a;
        }
    }

    public static class StringReverserPSAT implements ProblemSpecAndTools {
        private String s = "";
        private String a = ""; //accumulator
        private int c; //counter

        public StringReverserPSAT(String s) {
            this.s = s;
            this.a = "";
            this.c = s.length();
        }

        public boolean isBaseCase() {
            return c == 0;
        }

        public void reduceProblem() {
            c--;
        }

        public void updateAccumulatorBaseCase() {
            // do nothing
        }

        public void updateAccumulatorNonBaseCase() {
            a += s.charAt(c-1);
        }

        public String toString() {
            return a;
        }

        public Object accumulator() {
            return a;
        }
    }

    public static class GcdPSAT implements ProblemSpecAndTools {
        private int a;
        private int b;
        private int c; //accumulator

        public GcdPSAT(int a, int b) {
            this.a = a;
            this.b = b;
            this.c = 1;
        }

        public boolean isBaseCase() {
            return a == 0 || b == 0;
        }

        public void reduceProblem() {
            if (b > a) {
                int oldA = a;
                a = b % a;
                b = oldA;
            }
            int oldB = b;
            b = a % b;
            a = oldB;
        }

        public void updateAccumulatorBaseCase() {
            // do nothing
        }

        public void updateAccumulatorNonBaseCase() {
            // do nothing
        }

        public String toString() {
            return "" + a;
        }

        public Object accumulator() {
            return a;
        }
    }
}