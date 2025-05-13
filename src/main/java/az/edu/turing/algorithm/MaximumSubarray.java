package az.edu.turing.algorithm;

import java.util.Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum =Integer.MIN_VALUE;
        int curSum=0;

        for(int num:nums){
            curSum+=num;
            if(curSum>maxSum){
                maxSum=curSum;
            }
            if(curSum<0){
                curSum=0;
            }
        }
        return maxSum;


    }



    public static void main(String[] args) {
        int[] nums1= new int[]{-2,1,-3,4,-1,2,1,-5,4};
      System.out.println(maxSubArray(nums1));
        int[] nums2= new int[]{5, 4, -1, 7 ,8};
        System.out.println(maxSubArray(nums2));
        int[] num3 = new int[]{-2,1};
        System.out.println(maxSubArray(num3));



    }
}
