package DFS;

public class InvertBinaryTree {
    // Problem: Given a binary tree, invert its nodes
    // The time complexity is O(n) where n is the size of the tree
    public static Node<Integer> invertTree(Node<Integer> tree){
        // If it's null we just return null for the node
        if(tree == null) return null;
        // Here we just swap the sides and call the function recursively before return the tree itself already sorted
        Node<Integer> temp = tree.left;
        tree.left = invertTree(tree.right);
        tree.right = invertTree(temp);

        return tree;
    }
}
