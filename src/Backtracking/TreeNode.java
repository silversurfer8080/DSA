package Backtracking;

import java.util.List;

public class TreeNode<T> {
    public T val;
    List<TreeNode<T>> children;
    public TreeNode(T val,  List<TreeNode<T>> children) {
        this.val = val;
        this.children = children;
    }

}
