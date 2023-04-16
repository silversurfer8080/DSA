package DFS;

public class FindMaxValueInTreeBinaryNode {

    //Find the max element in the Node or return -1 if the node is null
    public static int maxValueInBinaryTree(Node<Integer> node){

        // Edge case:
        if(node == null) {
            return -1;
        }
        // Making a recursive calls to both sides of the node to compare between them.
        int leftMaxValue = maxValueInBinaryTree(node.left);
        int rightMaxValue = maxValueInBinaryTree(node.right);

        return Integer.max(Integer.max(leftMaxValue, rightMaxValue), node.val);
    }
}
