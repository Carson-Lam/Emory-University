// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
// A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Carson Lam

import java.awt.dnd.DropTarget;

public class AVLTree<K extends Comparable<K>> extends BST<K>
{
    protected Node fixup(Node t)
    {
        t.update();             // update t.size and t.height

        int bal = height(t.left) - height(t.right);
        //Balance factor within [-1,1], so already balanced
        if (-1 <= bal && bal <= +1)
            return t;


        //Trinode restructuring:

        // Left heavy tree
        if (bal > 1) {
            //Single rotation: left-left case with x on left branch of y, y on left branch of z
            if (height(t.left.left) >= height(t.left.right)) {
                return rotateRight(t);
            //Double rotation: left-right case with x on right branch of y, y on left branch of z
            } else {
                t.left = rotateLeft(t.left);
                return rotateRight(t);
            }
        //Right heavy tree
        } else {
            //Single rotation: right-right case with x on right branch of y, y on right branch of z
            if (height(t.right.right) >= height(t.right.left)) {
                return rotateLeft(t);
            //Double rotation: right-left case with x on left branch of y, y on right branch of z
            } else {
                t.right = rotateRight(t.right);
                return rotateLeft(t);
            }
        }
    }
    Node rotateRight(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k2.update(); // update size and height
        k1.right = k2;
        k1.update(); // update size and height
        return k1;   // return new root of this subtreee
    }

    Node rotateLeft(Node k2) {
        Node k1 = k2.right;
        k2.right = k1.left;
        k2.update(); // update size and height
        k1.left = k2;
        k1.update(); // update size and height
        return k1;   // return new root of this subtreee
    }
}
