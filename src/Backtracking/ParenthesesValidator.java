package Backtracking;

import java.util.Stack;

public class balance  {
        public static boolean isBalanced(String input) {
            if (input == null || input.isEmpty()) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (!isMatchingPair(top, c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
        private static boolean isMatchingPair(char opening, char closing) {
            return (opening == '(' && closing == ')') ||
                    (opening == '{' && closing == '}') ||
                    (opening == '[' && closing == ']');
        }
        public static void main(String[] args) {
            System.out.println(isBalanced("{[()]}")); // true
            System.out.println(isBalanced("{[(])}")); // false
            System.out.println(isBalanced("{{[[(())]]}}")); // true
            System.out.println(isBalanced("{[}")); // false
        }
    }
}
