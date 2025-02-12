import java.util.Scanner;

public class TowersOfHanoi {

    // Instance Variables
    int maxNumDisks = 4;
    int[][] diskWidths = new int[3][4];
    int[] topDisk = new int[3];

    // Constructors
    public TowersOfHanoi(int numDisks) {
        maxNumDisks = numDisks;
        diskWidths = new int[3][maxNumDisks];
        topDisk = new int[3];
        for (int i = 0; i<maxNumDisks;i++){
            diskWidths[0][i] = 2*(maxNumDisks-i)-1;
        }
        topDisk[0] = numDisks -1;
        topDisk[1] = -1;
        topDisk[2] = -1;
    }

    private int baseWidth() {
        return 2*maxNumDisks+1;
    }

    private String pad(int diskWidth) {
        String s = (diskWidth == 0 ? " " : "");
        for (int i = 0; i < diskWidth; i++)
            s += "\u2588";
        int padding = (this.baseWidth()-diskWidth)/2;
        for (int i = 0; i < padding; i++)
            s = " " + s + " ";
        return s;
    }

    public String toString() {
        // draw disks
        String s = "";
        for (int level = maxNumDisks-1; level >= 0; level--) {
            for (int tower = 0; tower < 3; tower++) {
                s += pad(diskWidths[tower][level]);
            }
            s += System.lineSeparator();
        }

        // draw "floor" and number the piles/pegs..
        for (int i = 0; i < 3*this.baseWidth(); i++) s += "=";
        s += System.lineSeparator();
        for (int i = 0; i < this.baseWidth()/2; i++) s += " ";
        s += "0";
        for (int i = 0; i < this.baseWidth()-1; i++) s += " ";
        s += "1";
        for (int i = 0; i < this.baseWidth()-1; i++) s += " ";
        s += "2";
        return s;
    }

    //Instance methods
    public boolean won() {
        return topDisk[2] == maxNumDisks-1;
    }

    public boolean legalMove(int from, int to){
        if (from > 2 || to > 2 || from < 0 || to < 0){
            return false;
        }

        if (topDisk[from]==-1){
            return false;
        }

        if (topDisk[to] == -1) {
            return true;
        }

        int fromDiskWidth = diskWidths[from][topDisk[from]];
        int toDiskWidth = diskWidths[to][topDisk[to]];
        return fromDiskWidth < toDiskWidth;
    }

    public void move(int from, int to){
        int movingDisk = diskWidths[from][topDisk[from]];
        if (topDisk[to]==-1){
            diskWidths[to][0] = movingDisk;
            topDisk[to]=0;
        } else {
            diskWidths[to][topDisk[to]+1] = movingDisk;
            topDisk[to]++;
        }
        diskWidths[from][topDisk[from]]=0;
        if (topDisk[from]==0){
            topDisk[from]=-1;
        } else {
            topDisk[from]--;
        }
    }

    public static void main(String[] args) {
        System.out.println("How many disks do you want to use?");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        int numDisks = lineScanner.nextInt();
        lineScanner.close();

        System.out.println(System.lineSeparator() + "Goal: Move all the disks from pile 0 to pile 2" + System.lineSeparator());
        System.out.println("Restrictions: You can only move a top-most disk " + System.lineSeparator() +
                "from one pile onto another pile that is either " + System.lineSeparator() +
                "empty or whose top-most disk is larger than the one " + System.lineSeparator() +
                "moved" + System.lineSeparator());
        System.out.println("To move a disk from pile X to pile Y: " + System.lineSeparator() +
                "Type 'XY' and then hit 'enter'" + System.lineSeparator() +
                "To quit the  game, type 'exit'." + System.lineSeparator());

        TowersOfHanoi toh = new TowersOfHanoi(numDisks);
        System.out.println(toh);

        while (!toh.won() && scanner.hasNextLine()) {

            line = scanner.nextLine();

            if(line.equalsIgnoreCase("exit")) {
                return;
            }

            if (line.isEmpty()) {
                System.out.println("ILLEGAL MOVE");
            }

            int from = line.charAt(0)-'0';
            int to = line.charAt(1)-'0';

            if (toh.legalMove(from,to)) {
                toh.move(from,to);
                System.out.println(toh);
            }
            else {
                System.out.println("ILLEGAL MOVE");
            }
        }
        System.out.println("YOU DID IT!");
        scanner.close();
    }
}