package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers sum to target.
public class DuplicationSum {
    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        Collections.sort(candidates);
        dfs(candidates, target, res, seq, 0, 0);
        return res;
    }

    private static void dfs(List<Integer> candidates, int target, List<List<Integer>> res, List<Integer> seq, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(seq));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            sum += candidates.get(i);
            if (sum > target) break;

            seq.add(candidates.get(i));
            dfs(candidates, target, res, seq, sum + candidates.get(i), i);
            seq.remove(seq.size() - 1);
        }
    }
}
