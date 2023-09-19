package BFSOnTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a binary tree, return its level order traversal but in alternate left to right order.
public class ZigZagTreeOrder {

    public static List<List<Integer>> zigZagTraversal( Node<Integer> root){
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        // At least one element in the queue to start bfs
        queue.add(root);
        // Our flag to set the direction
        boolean leftToRight = true;

        while (queue.size() > 0){ // As long there is an element in the queue
            int n = queue.size(); // Number of nodes in the current level
            ArrayDeque<Integer> newLevel = new ArrayDeque<>();
            // Dequeue each mode in the current level
            for (int i = 0; i < n; i++){
                Node<Integer> node = queue.pop();
                if(leftToRight){
                    newLevel.add(node.val);
                } else { // In the reverse order
                    newLevel.addFirst(node.val);
                }
                // enqueue the non-null children
                if(node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(Arrays.asList(newLevel.toArray(new Integer[0])));
            leftToRight = !leftToRight; // Time to flip the flag
        }
        return result;
    }
}
