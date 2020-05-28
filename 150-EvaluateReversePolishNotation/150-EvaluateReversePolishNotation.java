/*

150. Evaluate Reverse Polish Notation
Medium

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

*/
class Solution {
    public int evalRPN(String[] tokens) {
        //stack based approach
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
                stack.push(Integer.valueOf(s));
            else{
                int temp = 0;
                if(stack.size() < 2) return -1;
                if(s.equals("+"))
                    temp = stack.pop() + stack.pop();
                else if(s.equals("-")){
                    int t1 = stack.pop();
                    int t2 = stack.pop();
                    temp = t2 - t1;
                }
                else if(s.equals("*"))
                    temp = stack.pop() * stack.pop();
                else{
                    int t1 = stack.pop();
                    int t2 = stack.pop();
                    if(t1 == 0) {
                        stack.push(0);
                        continue;
                    }
                    temp = t2 / t1;
                }
                stack.push(temp);
            }
        }
        return stack.size() == 0 ? -1 : stack.pop();
    }
}
