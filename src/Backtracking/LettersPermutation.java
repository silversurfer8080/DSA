package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Given a string of unique letters, find all of tis distinct permutations.
public class LettersPermutation {
    public static List<String> permutations(String s) {
        char[] letters = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), new boolean[letters.length], res, letters);
        return res;
    }

    private static void dfs(int startIndex, ArrayList<Object> path, boolean[] used, List<String> res, char[] letters) {
        if(startIndex == used.length){
            // Make a deep copy since otherwise we'd be append the same list over and over.
            res.add(path.stream().map(e -> e.toString()).collect(Collectors.joining()));
            return;
        }

        for (int i = 0; i < used.length; i++){
            // Skip used letters
            if(used[i]) continue;
            // Add letter to permutation, mark the letter as used
            path.add(letters[i]);
            used[i] = true;
            dfs(startIndex+1, path, used, res, letters);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // The time complexity is O(n!) and the Space complexity is given by the height of the state-space tree, which is O(n).

}
