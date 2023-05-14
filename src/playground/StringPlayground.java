package playground;

import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringPlayground {

    public static String reverseString(String stringueira){
        StringBuilder sb = new StringBuilder(stringueira);
        return sb.reverse().toString();
    }
    public static String reverseString2(String stringueira){
        char ch;
        String reverseString ="";
        for (int i =0; i < stringueira.length(); i++){
            ch = stringueira.charAt(i);
            reverseString = ch+reverseString;
        }
        return reverseString;
    }

    public static String reverseString3(String stringueira){

        String reverseString ="";
        for (int i = stringueira.length()-1 ; i >=0; i--){
            reverseString += stringueira.charAt(i);
        }
        return reverseString;
    }

    public static boolean isAnagram(String word1, String word2){
        boolean result = false;
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1,arr2)) result = true;

        return result;
   }
    public static boolean isAnagram1(String word1, String word2){
        boolean result = false;
        if(word1 == null  || word2 == null) return false;
        if(word1.length() != word2.length()) return false;

        int hash1[] = new int[26];
        int hash2[] = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            hash1[i] =word1.charAt(i)-'a';
            hash2[i] =word2.charAt(i)-'a';
        }

        if(hash1.equals(hash2)) result = true;

        return result;
   }
    public static boolean isPalindrome1(String word1){
        boolean result = false;
        String palindromeWord1 = "";
        for (int i = word1.length()-1; i >= 0; i--) {
            palindromeWord1 += word1.charAt(i);
        }
        if(word1.equals(palindromeWord1)) result = true;
        return result;
   }










}
