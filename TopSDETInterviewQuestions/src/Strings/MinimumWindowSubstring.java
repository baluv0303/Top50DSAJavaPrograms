package TopSDETInterviewQuestions.src.Strings;

public class MinimumWindowSubstring {

    public static void main(String[] args){
        String s= "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minimumWindowSubstringBrute(s,t));
        System.out.println(minimumWindowSubstringSlidingWindow(s,t));

    }

    public static String minimumWindowSubstringSlidingWindow(String s, String t){
        if(s.isEmpty() || t.isEmpty()) return "";

        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int left =0, right =0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()){

            char r = s.charAt(right);

            if(freq[r] > 0){
                required--;
            }

            freq[r] --;
            right++;

            while (required ==0){
                if(right - left < minLen){
                    minLen = right -left;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++;
                if(freq[l] > 0){
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static String minimumWindowSubstringBrute(String s, String t){
        String res = "";
        int n = s.length();

        for(int i=0; i<n; i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i, j+1);
                if(isValid(t, sub)){
                    if(res.isEmpty() || res.length() > sub.length()){
                        res = sub;
                    }
                }
            }
        }
        return res;

        // Time = O(n³)
        // Space = O(1)
    }


    public static boolean isValid(String t, String s){
        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        for(char c : s.toCharArray()){
            freq[c]--;
        }

        for(int f : freq){
            if(f>0) return false;
        }
        return true;
    }
}
