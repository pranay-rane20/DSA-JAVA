package Leetcode;

public class L14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (String s : strs) {
//            System.out.println(s);
            while (s.indexOf(prefix) != 0){

                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
            }
            System.out.println(prefix);
        }
        return prefix;
    }

    
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
//        longestCommonPrefix(strs);
    }
}
