/*

844. Backspace String Compare
Easy

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#'){
                if (!sStack.isEmpty())
                    sStack.pop();
                continue;
            }
              sStack.push(S.charAt(i));
        }
        for (int i = 0; i < T.length(); i++){
            if(T.charAt(i) == '#'){
                if (!tStack.isEmpty())
                    tStack.pop();
                continue;
            }
            tStack.push(T.charAt(i));
        }
        while(!sStack.isEmpty() && !tStack.isEmpty()){
            if(sStack.pop() != tStack.pop())
                return false;
        }
        if (sStack.isEmpty() && tStack.isEmpty())
            return true;
        return false;
    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = getString(s);
        String s2 = getString(t);
        return s1.equals(s2);
    }
    private String getString(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '#' && sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            else if(ch != '#') sb.append(ch);
        }
        return sb.toString();
    }
}
