package Backtracking;
// We have a message consisting of digits 0-9 to decode.
// Letters are encoded to digits by their position in the alphabet.
// A -> 1, B -> 2, C -> 3... y -> 25, z -> 26.

public class DecodeMessage {
    // Given a non-empty string of digits, how many ways are there to decode it?
    // Example: Input: 18 Output: 2, 18 can be decoded as "AH" or "R".
    public static int decodeWays(String digits){
        return dfs(0, digits);
    }

    // The time complexity overall is O(n²).
    private static int dfs(int startIndex, String digits) {
        if(startIndex == digits.length()) return 1;

        int ways = 0;
        // Can not decode string with leading 0
        if(digits.charAt(startIndex) == '0') return ways;
        // Decode one digit
        ways += dfs(startIndex + 1, digits);
        // Decode two digits
        if(startIndex + 2 <= digits.length() && Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
            ways += dfs(startIndex + 2, digits);
        }
        return ways;
    }

}
