package Backtracking;

import java.util.Arrays;

public class DecodeMessage2 {
    private static int dfs(int startIndex, String digits, int [] memo) {
        if(startIndex == digits.length()) return 1;
        if(memo[startIndex] != -1) return memo[startIndex];

        int ways = 0;
        // Can not decode string with leading 0
        if(digits.charAt(startIndex) == '0') return ways;
        // decode one digit
        ways += dfs(startIndex + 1, digits, memo);
        // decode two digits
        if(startIndex + 2 <= digits.length() && Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
            ways += dfs(startIndex + 2, digits, memo);
        }
        memo[startIndex] = ways;
        return ways;
    }

    public static int decodeWays(String digits){
        int [] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return dfs(0, digits, memo);
    }

    // Time complexity of the memoization solution is the size of the memo array O(n) multiplied by the number of operations per state which is O(1).
}
