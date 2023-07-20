package Backtracking;

import java.util.ArrayList;
import java.util.List;

// Given a set of distinct integers, nums, return all possible subsets (the power set).
public class Subset2 {
    public static List<List<Integer>> subsets(List<Integer> nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        dfs(nums, res, seq, 0);
        return res;
    }

    private static void dfs(List<Integer> nums, List<List<Integer>> res, List<Integer> seq, int i) {
        res.add(new ArrayList<>(seq));
        for (int j = i; j < nums.size(); j++) {
            seq.add(nums.get(j));
            dfs(nums, res, seq, j + 1);
            seq.remove(seq.size() - 1);
        }
    }
}
