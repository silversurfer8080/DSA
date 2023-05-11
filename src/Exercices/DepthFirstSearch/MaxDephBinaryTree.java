package Exercices.DepthFirstSearch;

import java.util.Iterator;
import java.util.function.Function;

public class MaxDephBinaryTree {

    // The time complexity is O(n). The space complexity is O(h) where h is the height of the tree
    private static int dfs(Node<Integer> root) {
        // Null node adds no depth.
        if (root == null) return 0;
        // Num nodes in the longest path of current subtree = max num nodes of its two subtrees + 1 current node.
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public static int treeMaxDepth(Node<Integer> root) {
        return (root != null) ? dfs(root) - 1 : 0;
    }

    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
