package TopSDETInterviewQuestions.src.Strings;

public class StringCompression {

    public static void main(String[] args){
        String s = "aaaabbbbbbbcyyyjjjjjjj";
        System.out.println(compressStringBrute(s));
    }

    public static String compressStringBrute(String s){
        if (s == null || s.length() < 1) return "";
        String compress= "";
        StringBuilder sb = new StringBuilder();
        int count =1;
        for(int i=1; i<= s.length(); i++){
            if(i < s.length() && s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else {
                sb.append(s.charAt(i-1));
                sb.append(count);
                count =1;
            }
        }
        return sb.toString();

//        ⏱ Complexity:
//        Time: O(n) ✅
//        Space: O(n)

    }
}
