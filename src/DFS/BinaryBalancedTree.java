package DFS;

public class BinaryBalancedTree {
    // Returns -1 if is not a balanced binary tree. The height if it is.
    public static int treeHeight(Node<Integer> tree) {
        if (tree == null) {
            return 0;
        }
        int leftHeight = treeHeight(tree.left);
        int rightHeight = treeHeight(tree.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1 ) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(Node<Integer> tree) {
        return treeHeight(tree) != -1;
    }

}
