package az.edu.turing.module03.algorithm;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        int original =x;
        int reversed = 0;
        while(x>0){
            reversed = reversed*10 + x%10;

            x/=10;
        }

        return  original==reversed;

    }
    public static void main(String[] args) {

        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(13214));
        System.out.println(isPalindrome(14441));

    }
}
