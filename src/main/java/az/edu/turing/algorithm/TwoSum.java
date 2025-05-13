package az.edu.turing.algorithm;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int x= target-nums[i];

            if(map.containsKey(x)){
                res[0] = map.get(x);
                res[1] = i;



            }

            map.put(nums[i],i);


        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        twoSum(nums,9);
    }
}
