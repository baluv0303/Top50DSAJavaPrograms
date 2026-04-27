package TopSDETInterviewQuestions.src.Arrays;

public class TrappingRainWater {

    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights2 = {1,3,0,4,7,2,0,8};

        System.out.println("Water trapped using bruteforce method is " + findTrappedWaterBrute(heights) + " units");
        System.out.println(findTrappedWaterBrute(heights2));

        System.out.println("Water trapped using bruteforce method is " + findTrappedWaterTwoPointers(heights) + " units");
        System.out.println(findTrappedWaterTwoPointers(heights2));


    }

    public  static int findTrappedWaterTwoPointers(int[] heights){
        int n = heights.length;
        int left = 0, right = n -1;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            if(heights[left] < heights[right]){
                if(heights[left] >= leftMax){
                    leftMax = heights[left];
                }
                else {
                    water += leftMax - heights[left];
                }
                left++;
                }
            else {
                if(heights[right] >= rightMax){
                    rightMax = heights[right];
                }
                else {
                    water += rightMax - heights[right];
                }
            }
        }
        return water;
        // ⏱ Complexity:
        // Time: O(n)
        // Space: O(1)

        //Always move from the smaller wall because it limits how much water can be stored.
    }
    public static int findTrappedWaterBrute(int[] heights){

        int n = heights.length;
        int water = 0;
        for(int i=0; i< n; i++){
            int leftMax =0, rightMax=0;

            for(int j=0; j<=i ; j++){
                leftMax = Math.max(leftMax, heights[j]);
            }

            for(int j=i; j<n ; j++){
                rightMax = Math.max(rightMax, heights[j]);
            }

            water += Math.min(rightMax, leftMax) - heights[i];
        }
        return water;
//       ⏱ Complexity:
//        Time: O(n²)
//        Space: O(1)
    }
}
