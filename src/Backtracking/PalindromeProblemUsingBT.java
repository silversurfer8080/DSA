package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromeProblemUsingBT {
    // Given a string s, partition s such that every substring of the partition is a palindrome.
    // Return all possible palindrome partitioning of s.
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l<r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void dfs(List<List<String>> ans, ArrayList<String> part, String s,  int start){
        if (start == s.length()) {
            List<String> list =  new ArrayList<>(part);
            ans.add(list);
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                part.add(s.substring(start, end + 1));
                dfs(ans, part, s, end + 1);
                part.remove(part.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> part = new ArrayList<>();
        dfs(ans, part, s, 0);
        return ans;
    }

}
