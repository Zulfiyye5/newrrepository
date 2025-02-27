package az.edu.turing.module1.lesson04;

import java.util.Scanner;

public class ArrayLesson {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array:");
        int length = scanner.nextInt();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter number:  ");
            arr[i] = scanner.nextInt();

        }

        int maxNumber = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }
        }
        System.out.println(maxNumber);
    }
}
