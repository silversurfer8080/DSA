package Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given a ternary tree( each node of the tree has at most three children), find all root-to-leaf paths
public class TernaryTreePaths {


    public static List<String> ternaryTreePaths(TreeNode<Integer> root) {
        ArrayList<String> res  = new ArrayList<>();
        if(root != null) {
            dfs(root, new ArrayList<String>(), res);
        }
        return res;
    }

    private static void dfs(TreeNode<Integer> root, ArrayList<String> path, ArrayList<String> res) {
        // Exit condition, reach leaf node, append paths to results
        if(root.children.size() == 0){
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        // Recursive call DFS  on each non-null child
        for(TreeNode<Integer> child : root.children){
            if(child != null){
                path.add(Integer.toString(root.val));
                dfs(child, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
