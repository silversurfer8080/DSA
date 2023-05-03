package BST;

import DFS.Node;

public class ValidBST {

    // Find out if a BST is valid, which means all the left nodes of the tree must be smaller.
    // The time complexity is O(n), since we have to visite every node of tree.

    public static boolean dfs(Node<Integer> root, int min, int max){
        // Edge case,  root is null.
        if(root == null) return true;
        // Conditional to check if both sides are respecting the criteria to be a BST.
        if(min > root.val  || root.val > max) return false;
        // Recursive calls to move down the tree checking both sides.
        // This time assuming in the left node we have the max value which is root val itself and for the right node
        // we have root val itself as the min value. In this way we guarantee that we are keeping in the edge of a valid BST.
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static boolean validateBST(Node<Integer> node){
        // Here we use the approach to put an initial range where we here have a max and min value to stay between.
        // while we go down in the tree nodes.
        return dfs(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
