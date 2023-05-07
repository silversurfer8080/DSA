package BST;

import DFS.Node;

// This is an example about how to insert a node into a valid bst and return this new bst with the addition of the new item
// if the value to be add in the valid bst, does nothing, don't insert anything and .
// This example expand the original tree by adding a leaf node.
public class InsertBST {
    public static Node<Integer> insertBst(Node<Integer> bst, int val){
        // Edge case
        if(bst == null) return new Node<Integer>(val);

        int comparator =  bst.val.compareTo(val);
        if(comparator < 0){
            bst.right = insertBst(bst.right, val);
        } else if( comparator >0){
            bst.left = insertBst(bst.left, val);
        }
        return bst;
    }
}
