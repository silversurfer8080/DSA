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

    public static int maxValueUsingGlobalVariable(Node<Integer> node){
        // A global variable initialized to record the current max value.
        int maxValue = Integer.MIN_VALUE;

        // Edge case:
        if(node == null) {
            return -1;
        }
        // If the node is bigger we set the max value to it's value.
        if (node.val > maxValue){
            maxValue = node.val;
        }

        // And we keep tracking the values in every node searching to the left and them to the right.
        maxValueUsingGlobalVariable(node.left);
        maxValueUsingGlobalVariable(node.right);

        return maxValue;
    }

    public static int findDepthNode(Node<Integer> node){
        return node != null ? dfs(node) : 0;
    }

    private static int dfs(Node<Integer>node){
        // Edge case
        if(node == null) {
             return 0;
        }
        // Number of nodes in the longest path of current subtree is equal of number of nodes of its two subtrees + 1 root
        return Math.max(dfs(node.left), dfs(node.right))+1;
    }

}
