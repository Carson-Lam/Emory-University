package SortableList;
//SUBMITTED BY: Carson Lam
//HELPED BY: Nobody
/////////////////////////////////////////////////////////////////////////////////
public class SortableList<Item extends Comparable<Item>> {
    public class Node {
        Item item;
        Node next;
    
        Node(Item item) {
            this.item = item;
        }
    }
    private Node head;
    private Node tail;
    
    public void add(Item item) {  // this method adds a new node containing item at the head of the list
        Node n = new Node(item);
        n.item = item;
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }
    
    private void exch(Node n, Node m) {  //swaps items inside nodes n and m (not the references)
        Item item = n.item;
        n.item = m.item;
        m.item = item;
    }
    
    private Node partition(Node lo, Node hi) {
        if (lo == null | hi == null) return null;
        Node i = lo;
        Node previous = null;
        Node pivot = hi;
        for(Node j = lo; j!=hi; j=j.next){
            if(less(j.item, pivot.item)) {
                exch(i,j);
                previous = i;
                i = i.next;
            }
        }
        exch(i,pivot);
        return (previous ==lo) ? null: previous;
    }
    
    public void sort() {
        sort(head,tail);
    }
    
    private void sort(Node lo, Node hi) {
        if (lo == null || lo == hi || lo == hi.next) return;
        Node pivot = partition(lo, hi);
        if (pivot != null) sort(lo, pivot);
        if (pivot != null && pivot.next != null) {
            sort(pivot.next, hi);
        } else if (pivot == null){
            sort(lo.next,hi);
        }
    }
    
    public String toString() {
        String s = "";
        for (Node n = head; n != null; n = n.next) {
            s += n.item + (n.next != null ? "->" : "");
        }
        return s;
    }
    
    public static SortableList<Character> convertStringToSortableList(String s) {
        SortableList<Character> list = new SortableList<Character>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return list;
    }
    
    public static void main(String[] args) {
        String[] words = {"hungry","ambidextrous","zombies","eat","brains","with","both","hands"};
        for (String word : words) {
            SortableList<Character> list = convertStringToSortableList(word);
            list.sort();
            System.out.println(list);
        }
    }
    }