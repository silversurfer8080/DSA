package BFSOnTrees;
// Given a binary tree, return its level order traversal. The input is the root node of the tree.
// The output should be a list of lists of integers, with the ith list containing the values of nodes on level i,
// from left to right.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalOrder {
    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> res =  new ArrayList<>();
        if(root == null) return res;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        // At least one element in the queue to kick-start bfs
        queue.add(root);
        // As long as the queue is not empty
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> newLevel =  new ArrayList<>();
            // Dequeue each node in the current level
            for (int i = 0; i <n; i++){
                Node<Integer> node = queue.pop();
                newLevel.add(node.val);
                // enqueue non-null children
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(newLevel);

        }
        return res;
    }
}
