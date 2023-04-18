package DFS;

// A search for the visible nodes of a tree. Visible node is when no node on the root position has a greater value, so if
// the child has a greater value than his root father, it's visible.

// The time complexity for this solution is O(n) and the space complexity relies on height of the tree, wich is O(n) in
// the worst case.
public class VisibleTreeNode {

    public static int visibleTreeNode(Node<Integer> node){
        // Start maxSoFar with smallest Integer possible so any value root has is greater than it.
        return dfs(node, Integer.MIN_VALUE);
    }

    private static int dfs(Node<Integer> node, int maxSoFar) {
        // Edge case
        if (node == null) return 0;

        int total = 0;

        if(node.val > maxSoFar) total++;

        // MaxSoFar of the child node is the larger value of  a comparation between previous max and current node val.
        total += dfs(node.left, Math.max(maxSoFar, node.val));
        total += dfs(node.right, Math.max(maxSoFar, node.val));

        return total;
    }

}
