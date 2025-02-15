//SUBMITTED BY: Carson Lam
//HELPED BY: Noah Huff
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CombinationsFinder {

    final Choice INCLUDE = new Choice(true);
    final Choice OMIT = new Choice(false);

    private class Choice {

        private boolean include;

        public Choice (boolean x) {
            this.include = x;
        }

        public String toString() {
            String s = "";
            s+= (include == true ? "I" : "O");
            return s;
        }

        public boolean equals(Object o) {
            return (o != null) && (o instanceof Choice ) && ( ((Choice)o).include == this.include );
        }


    }

    private class State implements StateAllowingBacktracking<Choice> {

        private Stack<Choice> choicesMade;
        private int numIncluded;


        public State() {
            this.choicesMade = new Stack<Choice>();
        }

        private int numChoicesMade() {
            return choicesMade.size();
        }

        public boolean isSolution() {
            return numChoicesMade() == CombinationsFinder.this.n;
        }

        public List<CombinationsFinder.Choice> nextChoicesToConsider() {
            List<Choice> listOfChoices = new ArrayList<Choice>();
            listOfChoices.add(INCLUDE);
            listOfChoices.add(OMIT);
            return listOfChoices;
        }

        public boolean isValid(CombinationsFinder.Choice choice) {
            if (choice.equals(INCLUDE) && numOfIncluded(choice) == k) return false;
            if (choice.equals(OMIT) && numOfOmitted(choice) == n-k) return false;
            else return true;
        }

        int numOfIncluded(Choice choice) {
            int counter = 0;
            for (Choice prevChoices: choicesMade) {
                if (prevChoices.equals(INCLUDE)) counter ++;
            }
            return counter;
        }

        int numOfOmitted(Choice choice) {
            int counter = 0;
            for (Choice prevChoices: choicesMade) {
                if (prevChoices.equals(OMIT)) counter ++;
            }
            return counter;
        }

        public void makeChoice(CombinationsFinder.Choice choice) {
            choicesMade.push(choice);
        }

        public void undoChoice(CombinationsFinder.Choice choice) {
            choicesMade.pop();
        }


        public String toString() {
            String s = "{";
            int counter = 1;
            for (Choice c: choicesMade) {
                s += c;
            }
            s = s.substring(0,s.length())+"} = {";
            for (Choice c: choicesMade) {
                if (c.equals(INCLUDE)) {
                    s+= counter + ",";
                    counter++;
                }
                else counter++;


            }
            s = s.substring(0,s.length()-1)+"}";

            return s;
        }


    }

    private int n;
    private int k;
    private StateAllowingBacktracking<Choice> state;
    static private int numCombinationsFound;

    public CombinationsFinder(int n, int k) {
        this.n = n;
        this.k = k;
        this.state = new State();
        CombinationsFinder.numCombinationsFound = 0;
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
        numCombinationsFound++;
    }

    public static void main(String[] args) {
        System.out.println("Enter n and k separated by a space to find all combinations of k values selected from 1 to n:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        scanner = new Scanner(line);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        scanner.close();

        CombinationsFinder finder = new CombinationsFinder(n,k);
        finder.searchFromCurrentState();
        System.out.println("number of combinations found: " + CombinationsFinder.numCombinationsFound);
    }
}