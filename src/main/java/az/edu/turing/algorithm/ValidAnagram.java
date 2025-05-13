package az.edu.turing.algorithm;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
          //anagram   nagaram
        // 97 110 97 103 114 97 109
        //110 97 103 97 114 97 109
        //0 13 0 6 17 0 12
        //13 0 6 0 17 0 12
        if(s.length()!=t.length()){
            return false;
        }
        int[] abc = new int[26];
       for(int i=0;i<s.length();i++){
           int indexS= s.charAt(i)-'a';
           int indexT = t.charAt(i)-'a';
           abc[indexS]++;
           abc[indexT]--;
       }
        System.out.println(Arrays.toString(abc));
       for(int i:abc){
           if(i!=0){
               return false;
           }
       }
       return  true;


    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abab","baba"));
    }
}
