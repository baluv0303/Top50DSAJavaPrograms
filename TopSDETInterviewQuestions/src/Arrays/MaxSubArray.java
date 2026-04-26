package TopSDETInterviewQuestions.src.Arrays;

public class MaxSubArray {

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArrayKadane(nums);
        int result2 = maxSubArrayBrute(nums);
        System.out.println("Max sub-array is " + result2);
        System.out.println("Max sub-array is " + result);
    }

    public static int maxSubArrayBrute(int[] nums){
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i< n; i++){
            for (int j=i; j<n ; j++){
                int sum = 0;
                for(int k=i; k<j; k++){
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);

            }
        }
        return maxSum;
//        ⏱ Complexity
//        Time: O(n³)
//        Space: O(1)
    }


    public static int maxSubArrayKadane(int[] nums){
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int i = 0; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;

//        ⏱ Complexity
//        Time: O(n)
//        Space: O(1)
    }
}
