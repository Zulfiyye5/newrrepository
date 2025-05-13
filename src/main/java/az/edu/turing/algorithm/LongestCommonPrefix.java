package az.edu.turing.algorithm;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        Arrays.sort(strs);

        int index= 0;
        String res = "";
        String first = strs[0];
        String last = strs[strs.length-1];
        while(index<first.length() && index<last.length()){
            if(first.charAt(index)==last.charAt(index)){
                res+=first.charAt(index);
                index++;
            }
            else{
                return  res;
            }

        }
        return res;



    }
    public static void main(String[] args) {


        String[] strs =new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs2 =new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2));
    }
}
