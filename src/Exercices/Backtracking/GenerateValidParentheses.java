package Exercices.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// This is an exercise that take a int number of parentheses and generate all the valid ones
public class GenerateValidParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, 0, res, n);
        return res;
    }

    private static void dfs(int startIndex, ArrayList<Character> path, int openCount,   int closeCount, List<String> res, int n) {
        if(path.size() == 2 * n){
            res.add(path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining()));
            return;
        }
        // The openCount and closeCount are create to represent the number of open and close parenthesis, so they are addional states of the recursion.
        if(openCount < n){
            path.add('(');
            dfs(startIndex, path, openCount + 1, closeCount, res, n);
            path.remove(path.size() - 1);
        }
        if (closeCount < openCount) {
            path.add(')');
            dfs(startIndex, path, openCount, closeCount + 1, res, n);
            path.remove(path.size() - 1);
        }
    }
    // There are a^(2n) = 4^n combinations of parenthesis, but we prune the invalid branches early on.
    // The complexity is O(4^n).
    // The space complexity is O(n). The stack memory is bpunded by the height of the state-space tree, which is O(n) in the worst case.
}
