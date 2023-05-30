package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Backtracking {

    public static List<String> letterCombination(Integer n){
        List<String> res = new ArrayList<>();
        dfs(n, res, 0, new ArrayList<>());
        return res;
    }

    private static void dfs(Integer n, List<String> res, int startIndex, ArrayList<Character> path) {
        if(startIndex == n) {
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
            return;
        }
        for(char letter : new char[]{'a','b'}){
            path.add(letter);
            dfs(n, res, startIndex + 1, path);
            path.remove(path.size() - 1);
        }
        
    }
}
