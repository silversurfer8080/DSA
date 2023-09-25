package BFSOnTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the rightmost node of each level.
//It should be noted that at each level there can only be at most one rightmost node.
public class BinaryTreeRightSideView {
    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root); // At least one element in the queue to start bfs.

        while(!queue.isEmpty()){ // As long there is an element in the queue.
            int n = queue.size(); // Number of nodes in the current level.
            result.add(queue.peek().val); // Add the rightmost node of the current level.

            for (int i = 0; i < n; i++){
                Node<Integer> node = queue.pop();
                // Add right child first, so it'll pop out of the queue first.
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
        }
        return result;
    }
}
