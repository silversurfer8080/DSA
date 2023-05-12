package playground;

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






}
