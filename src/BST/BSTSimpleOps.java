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

    public static Node<Integer> deleteNode(Node<Integer> root, Integer valueToDelete){
        // Base case
        if(root == null) return root;

        // Recursivly calls for ancestors of node to be deleted
        if(root.val > valueToDelete){
            root.left = deleteNode(root.left, valueToDelete);
            return root;
        } else if(root.val < valueToDelete){
            root.right = deleteNode(root.right, valueToDelete);
            return root;
        }
        // After this we reach when the root is the node to be deleted. So we need operate here.
        // Now we must check about the childs to replace the root node.

        // If one of the children's node is empty
        if(root.left == null){
            Node<Integer> temp = root.right;
            return temp;
        } else if (root.right == null){
            Node<Integer> temp = root.left;
            return temp;
        } else { // If both children exist
            Node<Integer> succParent = root;
            // Find the sucessor
            Node<Integer> succ = root.right;
            while(succ.left != null){
                succParent = succ;
                succ = succ.left;
            }

            // Delete the successor since successor is always the left child of it's parent we can safely make
            // successor's right child as left of its parent.
            // If there is no succ, then assign succ -> right to succParent -> right.
            if(succParent != root){
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }

            // Copy the successor node to the root.
            root.val = succ.val;

            return root;
        }
    }


}












