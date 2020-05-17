/*

227. Basic Calculator II
Medium

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

    You may assume that the given expression is always valid.
    Do not use the eval built-in library function.

*/

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        s = s + "+"; //addding at the end so that we can add all the values left
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num *10 + ch - '0';
                continue;
            }
            if(!Character.isDigit(ch) && ch != ' '){
                if(op == '+')
                    stack.push(num);
                else if (op == '-')
                    stack.push(-num);
                else if (op == '*')
                    stack.push(stack.pop() * num);
                else if(op == '/')
                    stack.push(stack.pop() / num);
                op = ch;
                num = 0;
            }
        }
        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }
}
