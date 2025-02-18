//SUBMITTED BY: Carson Lam
//HELPED BY: Noah Huff
import java.util.Random;

public class RandomList {

    private class Node {
        int value;
        Node next;
    }

    private Node head;

    public RandomList(int bound, int size) {
        Random random = new Random();
        for(int i = 0; i <size;i++){
            Node newNode = new Node();
            newNode.value = random.nextInt(bound);
            newNode.next = head;
            head = newNode;

        }

    }

    public boolean isEmpty() {
        return (head == null);
    }

    public String toString() {
        String outputStr = "";
        Node current = head;
        while (current != null){
            outputStr += current.value;
            current = current.next;
            outputStr += "->";
        }
        return outputStr;
    }
//
    public void removeAdjacentDuplicates() {
        Node current = head;
        while (current.next != null){
            while (current.value == current.next.value) {
                if (current.next.next == null) {
                    current.next = null;
                    return;
                } else {
                    current.next = current.next.next;
                }
            }
            current = current.next;
        }
    }
    //
    public void removeAdjacentDuplicatesR() {

        head = removeAdjacentDuplicatesR(head);
    }

    private Node removeAdjacentDuplicatesR(Node firstNode) {
        if(firstNode == null || firstNode.next == null) return firstNode;

        if (firstNode.value == firstNode.next.value) {
            Node current = firstNode.next;
            while (current != null && firstNode.value == current.value) {
                current = current.next;
            }
            firstNode.next = removeAdjacentDuplicatesR(current);
            return firstNode;
        } else {
            firstNode.next = removeAdjacentDuplicatesR(firstNode.next);
            return firstNode;
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    // You may insert no more than one additional private instance method here //
    /////////////////////////////////////////////////////////////////////////////

    public int getMax() {
        Node current = head;
        int max = current.value;
        while (current.next != null){
            if (max < current.next.value) {
                max = current.next.value;
            }
            current = current.next;
        }
        return max;
    }
    
    public void removeMaxValues() {
        Node current = head;
        int current_max = getMax();
        while (current != null && current.value == current_max) {
            head = current.next;
            current = current.next;
        }
        while (current != null && current.next != null) {
            if (current.next.value == current_max) {
                current.next = current.next.next;

            } else {
                current = current.next;
            }
        }
    }

    public int itemInTheMiddle() {
        Node current = head;
        Node current2 = head;
        int counter = 0;
        while (current.next != null) {
            current = current.next;
            counter ++;
        }
        for (int i = 0;i<((counter+1)/2);i++){
            current2 = current2.next;
        }
        return current2.value;
    }


    public static void main(String[] args) {
        RandomList list = new RandomList(4,15);
        System.out.println("Random list:"  + System.lineSeparator()+ list + System.lineSeparator());
        list.removeAdjacentDuplicates();
        System.out.println("List with adjacent duplicates removed:" +
                System.lineSeparator() + list + System.lineSeparator());

        RandomList list2 = new RandomList(4,15);
        System.out.println("Another Random list:"  + System.lineSeparator()+ list2 + System.lineSeparator());
        list2.removeAdjacentDuplicatesR();
        System.out.println("List with adjacent duplicates removed recursively:" +
                System.lineSeparator() + list2 + System.lineSeparator());

        RandomList list3 = new RandomList(4,15); // make a new list
        System.out.println("A Third Random list:" + System.lineSeparator() + list3 + System.lineSeparator());
        System.out.println("Successively removing max values:");
        while (! list3.isEmpty()) {
            list3.removeMaxValues();
            System.out.println(list3);
        }
        RandomList list4 = new RandomList(100,(int) (5+20*Math.random())); // make a new list of random size
        System.out.println("A Fourth Random list:" + System.lineSeparator() + list4 + System.lineSeparator());
        System.out.println("The item in the middle is " + list4.itemInTheMiddle());
    }
}