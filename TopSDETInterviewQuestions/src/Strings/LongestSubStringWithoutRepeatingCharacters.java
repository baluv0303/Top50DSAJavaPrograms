package TopSDETInterviewQuestions.src.Strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstringBrute(s));
        System.out.println(lengthOfLongestSubstringSlidingWindow(s));

    }

    public static int lengthOfLongestSubstringSlidingWindow(String s){
        HashSet<Character> hs = new HashSet<>();
        int left =0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right ++){
            while (hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
//        Complexity
//        Time: O(2n) ≈ O(n)
//        Space: O(n)
    }


    public static int lengthOfLongestSubstringBrute(String str){

        int n = str.length();
        int maxLength = 0;

        for(int i=0; i<n; i++){
            HashSet<Character> hs = new HashSet<>();
            for (int j=i; j< n; j++){
                if(hs.contains(str.charAt(j))) break;
                hs.add(str.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
//        Complexity
//        Time: O(n³) (substring + checking)
//        Space: O(n)
    }
}
