package TopSDETInterviewQuestions.src.Strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args){

        String s = "balulas";
        System.out.println(longestPalindromeBrute(s));
        System.out.println(longestPalindromeExpandAroundCenter(s));

    }

    public static String longestPalindromeExpandAroundCenter(String s){
        int n = s.length();
        if (s == null || n < 1) return "";
        int start = 0, end =0;


        for(int i=0; i< n ; i++){
            int len1 = expand(s, i,i); //odd length
            int len2 = expand(s,i, i+1);

            int len = Math.max(len1, len2);

            if(len > end-start){
                start = i - (len-1)/2 ;
                end = i+len/2;
            }
        }

        return s.substring(start, end+1);

//        Complexity:
//        Time: O(n²)
//        Space: O(1)

    }

    public static int expand(String s, int left, int right){
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
        return right-left-1;
    }


   public static String longestPalindromeBrute(String s){
       int n = s.length();
       String res = "";
       for (int i=0; i< n ; i++){
           for(int j = i; j< n ; j++){
               String sub = s.substring(i, j+1);
               if(isPalindrome(sub) && sub.length() > res.length()){
                   res = sub;
               }

           }
       }
       return res;
//       Complexity:
//       Time: O(n³)
//       Space: O(1)
   }


    public static boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
