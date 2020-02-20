/*

415. Add Strings
Easy

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/

class Solution {
    public String addStrings(String num1, String num2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for(int i =0; i<num1.length(); i++)
            s1.push(Character.getNumericValue(num1.charAt(i)));
        for(int i =0; i<num2.length(); i++)
            s2.push(Character.getNumericValue(num2.charAt(i)));
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int val = n1 + n2 + carry;
            if (val >= 10){
                val = val % 10;
                carry = 1;
            }
            else
                carry = 0;
            
            sb.append(val);
        }
        return sb.reverse().toString();
    }
}
