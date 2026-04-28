package TopSDETInterviewQuestions.src.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args){
        String s = "{[{()}]}";
        String s2 = "{[{()}]";

        System.out.println(isValidParenthesisStack(s));
        System.out.println(isValidParenthesisStack(s2));

        System.out.println(isValidParenthesisHashmap(s));
        System.out.println(isValidParenthesisHashmap(s2));
    }

    public static boolean isValidParenthesisHashmap(String str){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()){
            if(!map.containsKey(ch)){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || st.pop() !=map.get(ch)){
                    return false;
                }
            }
        }
        return st.isEmpty();
        //  ⏱ Complexity
        //  Time: O(n)
        //  Space: O(n)
        //“Push opening brackets onto a stack, and for each closing bracket,
        // use the map to check if it matches the last opening one.”
    }

    public static boolean isValidParenthesisStack(String str){
        Stack<Character> st = new Stack<>();
        char[] chars = str.toCharArray();
        for(char ch : chars){
            if(ch == '(' || ch == '{' || ch =='['){
                st.push(ch);
            }
            else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((ch == '(' && top != ')' ) || (ch == '{' && top != '}') || (ch == '[' && top != ']')){
                    return false;
                }
            }
        }

        return st.isEmpty();
//        ⏱ Complexity
//        Time: O(n)
//        Space: O(n)
//        Use a stack: push opening brackets, and for each closing bracket, check if it matches the top.
//        If mismatch or stack empty → invalid.
    }
}
