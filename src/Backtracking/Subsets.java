package Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given a set of distinct integers, nums, return all possible subsets (the power set).
public class Subsets {
    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        dfs(nums, res, seq, 0);
        return res;
    }

    private static void dfs(List<Integer> nums, List<List<Integer>> res, List<Integer> seq, int i) {
        if( i == nums.size()) {
            res.add(new ArrayList<>(seq));
        }
            seq.add(nums.get(i));
            dfs(nums, res, seq, i + 1);
            seq.remove(seq.size() - 1);
            dfs(nums, res, seq, i + 1);
    }
}
