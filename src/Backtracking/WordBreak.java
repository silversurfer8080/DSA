package Backtracking;

// Given a string and a list of words, determine if the string can be constructed from concatenating words from the list of words.
// A word can be use multiple times.
public class WordBreak {
    public static boolean wordBreak(String target, String[] words){
        return dfs(0, target, words);
    }

    private static boolean dfs(int startIndex, String target, String[] words) {
        // At this point we have created the entire target
        if( startIndex == target.length()) return true;

        boolean ans = false;

        for (String word : words){
            if (target.substring(startIndex).startsWith(word)){
                ans = ans || (dfs(startIndex + word.length(), target, words));
            }
        }
        return ans;
    }
}
