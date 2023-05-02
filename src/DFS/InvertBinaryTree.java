package DFS;

public class InvertBinaryTree {
    // Problem: Given a binary tree, invert it's nodes
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
