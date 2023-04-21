package DFS;

public class BinaryBalancedTree {
    // Returns -1 if is not a balanced binary tree. The height if it is.
    public static int treeHeight(Node<Integer> tree) {
        if(tree == null) return 0;

        int leftSubTreeHeight = treeHeight(tree.left);
        //if left subTree is not balanced then the entire tree is also not balanced.
        if(leftSubTreeHeight == -1) return -1;

        int rithSubTreeHeight = treeHeight(tree.right);
        //if right subTree is not balanced then the entire tree is also not balanced.
        if(rithSubTreeHeight == -1) return -1;

        // Checking the difference of left and right subtree. for current node.
        if(Math.abs(leftSubTreeHeight - rithSubTreeHeight) > 1) return -1;

        // If it's balanced then return the height
        return (Math.max(leftSubTreeHeight, rithSubTreeHeight) + 1);

    }
    private static boolean isBalanced(Node<Integer> tree) {
        return treeHeight(tree) != -1;
    }

}
