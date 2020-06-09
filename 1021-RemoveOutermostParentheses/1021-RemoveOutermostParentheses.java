/*

1021. Remove Outermost Parentheses
Easy

A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:

Input: "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".

Note:

    S.length <= 10000
    S[i] is "(" or ")"
    S is a valid parentheses string

*/

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Integer> s = new Stack<>(); //index
        int open = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '(' && open++ > 0)
                sb.append(ch);
            if(ch == ')' && open-- != 1)
                sb.append(ch);
        }
        return sb.toString();
    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Integer> s = new Stack<>(); //index
        int open = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                sb.append(ch);
                open++;
                s.push(i);
            }
            else{
                open--;
                int idx = s.pop();
                if(open == 0){
                    sb.deleteCharAt(idx - count);
                    count = count + 2;
                    continue;
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
