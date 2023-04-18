package DFS;

import java.util.Iterator;
import java.util.function.Function;

public class NodeTree {

    // Basic functions to get the values and print the tree node as inOrder(left/node/right)
    public static void inOrderTraversal(Node<Integer> root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }
    // Basic functions to get the values and print the tree node as preOrder(node/left/right)
    public static void preOrderTraversal(Node<Integer> root){
        if(root != null){
            System.out.println(root.val);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }
    // Basic functions to get the values and print the tree node as post Order(left/right/node).
    public static void postOrderTraversal(Node<Integer> root){
        if(root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    // Read a linear String input and make a binary tree.
    // Here we can use an input passed by terminal or other type of input with simple rules, first it's about the binary tree
    // second when given an "X" as input it means there is no subtree for that node
    public static <T> Node<T> buildTree(Iterator<String> it, Function<String, T> f){
        String val = it.next();
        if(val.equals("x")) return null;

        Node<T> left = buildTree(it, f);
        Node<T> right = buildTree(it, f);

        return new Node<T>(f.apply(val), left, right);
    }



}
