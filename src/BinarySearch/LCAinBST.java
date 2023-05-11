package BinarySearch;

import DepthFirstSearch.Node;

public class LCAinBST {

    public static int lcaOnBST(Node<Integer> node, int p, int q){
        if (p < node.val &&  q < node.val) {
            return lcaOnBST(node.left, p, q);
        } else if (p > node.val && q > node.val) {
            return lcaOnBST(node.right, p, q);
        } else {
            return node.val;
        }
    }
}
