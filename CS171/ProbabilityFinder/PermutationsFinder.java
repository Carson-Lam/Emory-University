
//SUBMITTED BY: Carson Lam
//HELPED BY: Noah Huff
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PermutationsFinder {

    private class Choice {


        private int c;

        public Choice (int c) {
            this.c = c;
        }

        public String toString() {
            return String.valueOf(c+1);
        }

        public boolean equals(Object o) {
            return (o != null) && (o instanceof Choice ) && ( ((Choice)o).c == this.c );
        }

    }

    private class State implements StateAllowingBacktracking<Choice> {

        private Stack<Choice> choicesMade;

        public State() {
            this.choicesMade = new Stack<Choice>();
        }

        private int numChoicesMade() {
            return choicesMade.size();
        }

        public boolean isSolution() {
            return numChoicesMade() == PermutationsFinder.this.k;
        }

        public List<PermutationsFinder.Choice> nextChoicesToConsider() {
            List<Choice> listOfChoices = new ArrayList<Choice>();
            for (int c = 0; c < n; c++) {
                listOfChoices.add(new Choice(c));
            }
            return listOfChoices;
        }

        public boolean isValid(PermutationsFinder.Choice choice) {
            for (Choice prevChoice: choicesMade) {
                if (choice.equals(prevChoice)) return false;
            }

            return true;
        }

        public void makeChoice(PermutationsFinder.Choice choice) {
            choicesMade.push(choice);
        }

        public void undoChoice(PermutationsFinder.Choice choice) {
            choicesMade.pop();
        }

        public String toString() {
            String s = "(";
            for (Choice c: choicesMade) {
                s += c + ",";
            }
            s = s.substring(0,s.length()-1)+")";
            return s;
        }

    }

    private int n;
    private int k;
    private StateAllowingBacktracking<Choice> state;
    static private int numPermutationsFound;

    public PermutationsFinder(int n, int k) {
        this.n = n;
        this.k = k;
        this.state = new State();
        PermutationsFinder.numPermutationsFound = 0;
    }

    public void searchFromCurrentState() {

        if (state.isSolution()) {
            reactToSolution();
            return; // stop pursuing this path
        }

        for (Choice choice : state.nextChoicesToConsider()) {
            if (state.isValid(choice)) {
                state.makeChoice(choice);
                searchFromCurrentState(); // <-- the recursive call!
                state.undoChoice(choice); // try another path
            }
        }
    }

    private void reactToSolution() {
        System.out.println(state);
        numPermutationsFound++;
    }

    public static void main(String[] args) {
        System.out.println("Enter n and k separated by a space to find all permutations of k values selected from 1 to n:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        scanner = new Scanner(line);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        scanner.close();

        PermutationsFinder finder = new PermutationsFinder(n,k);
        finder.searchFromCurrentState();
        System.out.println("number of permutations found: " + PermutationsFinder.numPermutationsFound);
    }
}