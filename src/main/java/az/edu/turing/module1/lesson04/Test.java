package az.edu.turing.module1.lesson04;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 99, 101, 4, 12};
        int maxNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }
        }
        System.out.println(maxNumber);
    }
}
