/*

67. Add Binary
Easy

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

*/

class Solution {
    public String addBinary(String a, String b) {
        //Approach 1
        //use stack
        //Aproach 2
        //use 2 pointer
        if (a.length() == 0 && b.length() == 0) return "0";
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i<a.length(); i++)
            s1.push(a.charAt(i));
        for (int i = 0; i<b.length(); i++)
            s2.push(b.charAt(i));
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(!s1.isEmpty() || !s2.isEmpty()){
            int t1 = s1.isEmpty() ? 0 : Character.getNumericValue(s1.pop());
            int t2 = s2.isEmpty() ? 0 : Character.getNumericValue(s2.pop());
            int val = carry + t1 + t2;
            if (val > 1)
                carry = 1;
            else
                carry = 0;
            sb.append(val % 2);
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
