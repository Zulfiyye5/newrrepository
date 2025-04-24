package az.edu.turing.module03.algorithm;

import java.util.Arrays;

public class AlgorithmDemo {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(13214));
        System.out.println(isPalindrome(14441));
        String[] strs =new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs2 =new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2));
    }


    public static boolean isPalindrome(int x) {
        int original =x;
        int reversed = 0;
        while(x>0){
            reversed = reversed*10 + x%10;

            x/=10;
        }

         return  original==reversed;

    }

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
}
