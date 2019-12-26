/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true

Question Link : https://leetcode.com/problems/valid-parentheses/

*/

class Solution {
    public boolean isValid(String s) {
        if (s.length()==0)
            return true;
        if (s.length()==1)
            return false;
        
        Stack <Character> tempStack = new Stack<>();
        Map <Character,Character> lookupMap = new HashMap<>();
        lookupMap.put('(',')');
        lookupMap.put('[',']');
        lookupMap.put('{','}');
        for (int i=0;i<s.length();i++)
        {
            if(lookupMap.containsKey(s.charAt(i)))
                tempStack.push(lookupMap.get(s.charAt(i)));
            else
            {
                if(tempStack.isEmpty()||s.charAt(i)!=tempStack.pop())
                    return false;
            }
        }
        return tempStack.isEmpty();
    }
}
