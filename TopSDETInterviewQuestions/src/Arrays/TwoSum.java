package TopSDETInterviewQuestions.src.Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args){
        int[] nums = {1,3,5,7,9,2,6};
        int target = 10;

       //int[] result= twoSumBrute(nums,target);

        int[] resultHm= twoSumBrute(nums,target);


       if(resultHm.length>0){
           System.out.println("Sum can be found at indices "+ resultHm[0] + " and "+ resultHm[1]);
       }

    }

    public static int[] twoSumHasmap(int[] nums , int taget){
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = taget - nums[i];
            if(hm.containsKey(complement)){
                return new int[] {hm.get(complement), i};
            }
            hm.put(nums[i], i);
        }
        return new int[] {};
    }

    public static int[] twoSumBrute(int[] nums, int target){

       for(int i=0; i< nums.length; i++){
           for(int j= i+1; j<nums.length; j++){
               if(nums[i] + nums[j] == target){
                   return new int[] {i,j};
               }
           }
       }
       return new int[] {};
    }
    //Time complexity O(n²)
}
