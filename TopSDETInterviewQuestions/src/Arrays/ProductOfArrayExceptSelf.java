package TopSDETInterviewQuestions.src.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productBruteForce(nums);

        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productBruteForce(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        for(int i= 0; i<n ; i++){
            int product = 1;
            for(int j=i; j<n; j++){
                if(i !=j){
                    product *=nums[j];
                }
            }
            res[i] = product;
        }
        return res;
    }
}
