package DFS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

// Here we gonna serialize and deserialize a binary tree base on Strings, serialize by a given sequence of String separate by empty space
// or deserialize by a given binary tree represented by the Node class.
public class SerializeAndDesilizeBT {
    // Here, to make the example more simple, we are going to use a StringJoiner class to help put the nodes in a serialized form
    // represented by a sequence of String. Note that, to represent a null node we are using a 'X' instead of null here.

    // The time complexity for both is O(n) to traverse n  nodes/elements.
    public static String serialize(Node<Integer> root){
        StringJoiner res = new StringJoiner(" "); // Use the utility class to help serialize.
        serializeDFS(root, res);
        return res.toString();
    }

    private static void serializeDFS(Node<Integer> root, StringJoiner result) {
        // The node is null we set it value to X in our representation.
        if(root == null){
            result.add("x");
            return;
        }
        // Otherwise we add the root value and call it to the left node and the right node recursively.
        result.add(Integer.toString(root.val));
        serializeDFS(root.left,result);
        serializeDFS(root.right,result);
    }

    public static Node<Integer> deserialize(String root){
        // Given a node stream made by a sequence of Strings separate only by the white spaces we call our recursive function.
        return deserializeDFS(Arrays.stream(root.split(" ")).iterator());
    }

    private static Node<Integer> deserializeDFS(Iterator<String> nodes) {
        // If we read a "x" from the sequence we know (by the rule we made) that is a null node
        String val = nodes.next();
        if(val.equals("x")) return null;
        // We create an new Node and for it's binary Childs we call the function recursively
        Node curr = new Node(Integer.parseInt(val));
        curr.left = deserializeDFS(nodes);
        curr.right = deserializeDFS(nodes);
        return curr;
    }


}
