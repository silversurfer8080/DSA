package Exercices.DepthFirstSearch;

import DepthFirstSearch.Node;

public class DFSSimpleSearch {

    // Given a integer target find and return the target in the tree.
    public static Node dfs(Node<Integer> root, int target){
        // Edge case:
        if(root == null){
            return null;
        }
        if(root.val == target){
            return root;
        }

        //returning a not null value from the recursive calls
        Node left = dfs(root.left, target);
        if(left != null){
            return left;
        }

        // If we get at this point, it means we know the left is null and we must check the right part of the tree
        //could be null or not null.
        return dfs(root.right, target);
    }
}
