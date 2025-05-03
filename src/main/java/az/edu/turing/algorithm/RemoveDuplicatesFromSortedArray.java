package az.edu.turing.algorithm;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int k=1;
        int number= nums[0];
        for(int i=1;i<nums.length;i++){
            if(number!=nums[i]){
                number = nums[i];
                nums[k] = number;
                k+=1;

            }

        }

        return  k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5};
        int k = removeDuplicates(nums);
        
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));

    }
}
