package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Giver a phone number that contains digits 0-9, find all possible letters combinations the phone number could translate to.
 * Example: 1  has no letter, 2 has abc, 3 has def, 4 has ghi, 5 has jkl, 6 has mno, 7 has pqrs, 8 has tuv, 9 has wxyz.
 * Input : 56
 *
 * Output : ["jm", "jn", "jo", "km", "kn", "ko", "lm", "ln", "lo"]
 */
public class PhoneNumbersCombo {
    private static List<String> res = new ArrayList<>();
    private static String phoneDigits;
    private static final Map<Character, char[]> KEYBOARD = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );
    public static List<String> letterCombination(String digits) {
            phoneDigits = digits;
            dfs(0, new StringBuilder());
            return res;
    }

    private static void dfs(int startIndex, StringBuilder path) {
        if(startIndex == phoneDigits.length()) {
            res.add(path.toString());
            return;
        }
        char next_digit = phoneDigits.charAt(startIndex);
        for (char letter : KEYBOARD.get(next_digit)) {
            path.append(letter);
            dfs(startIndex + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
 }


