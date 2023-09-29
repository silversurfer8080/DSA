package BFSOnTrees;

import java.util.ArrayDeque;

// Given a binary tree, find the depth of the shallowest leaf node.
public class BinaryTreeMinDepth {
    public static int binaryTreeMinDepth(Node<Integer> root) {
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root); // At least one element in the queue to start bfs.
        int depth = -1; // Starting from -1 because popping root will add 1 depth
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                if (node.left == null && node.right == null) return depth; // Found leaf node, early return;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    
}
