package DepthFirstSearch;

public class LowestCommonAncestor {

    public static Node<Integer> findLCA(Node<Integer> root, Node<Integer> node1, Node<Integer> node2){
        // Base case
        if(root == null) return null;

        if(root.equals(node1) || root.equals(node2)) return root;

        Node left = findLCA(root.left, node1, node2);
        Node right = findLCA(root.right, node1, node2);

        if(left != null && right != null) return root;

        if(left != null) return left;
        if(right != null) return right;

        return null;
    }
}
