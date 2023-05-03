package BST;

import DFS.Node;

public class BSTSimpleOps {
    // The time complexity here is O(h) where h is the height of the tree.
    // Here we bounded the type parameter in this generic type T so we can decide it's a subclass of Comparable class,
    // so we can use to compare, which it's something we need for this case, because we are going to compare the nodes
    // with the given value to find.
    public static <T extends Comparable<T>> boolean find(Node<T> tree, T valueToFind){
        // Edge case, the tree is null let's get out here.
        if(tree == null) return false;
        // Using the method inherited from the extended class Comparable.
        // This method return 0 if the values is equal, negative if it's smaller, positive if it's bigger.
        int compareVal = tree.val.compareTo(valueToFind);
        //Is it equal? So it's the root node itself, return it.
        if(compareVal == 0){
            return true;
        } else if(compareVal < 0){ // Is it smaller? It means the value is on the right side of the binary tree.
            return find(tree.right, valueToFind);
        } else {
            return find(tree.left, valueToFind); // Otherwise is smaller, which means the value is on the left  side.
        }
    }

    public static <T extends Comparable<T>> Node<T> insert(Node<T> tree, T valueToInsert){
        // Edge case.
        if(tree == null) return new Node<T>(valueToInsert);

        int compareVal = tree.val.compareTo(valueToInsert);

        if(compareVal < 0){
            tree.right = insert(tree.right, valueToInsert);
        } else if(compareVal > 0) {
            tree.left = insert(tree.left, valueToInsert);
        }
        return tree;
    }





}
