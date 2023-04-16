package DFS;

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
    // Basic functions to get the values and print the tree node as post Order(left/right/node)
    public static void postOrderTraversal(Node<Integer> root){
        if(root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    // Read an input to make a binary tree




}
