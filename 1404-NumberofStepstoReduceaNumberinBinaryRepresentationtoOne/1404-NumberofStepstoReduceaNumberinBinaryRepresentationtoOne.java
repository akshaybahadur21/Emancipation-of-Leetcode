/*

1404. Number of Steps to Reduce a Number in Binary Representation to One

Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

    If the current number is even, you have to divide it by 2.

    If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.

Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14. 
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.  
Step 5) 4 is even, divide by 2 and obtain 2. 
Step 6) 2 is even, divide by 2 and obtain 1.  

Example 2:

Input: s = "10"
Output: 1
Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.  

Example 3:

Input: s = "1"
Output: 0

Constraints:

    1 <= s.length <= 500
    s consists of characters '0' or '1'
    s[0] == '1'

*/


//TLE
class Solution {
    public int numSteps(String s) {
        long num = Long.parseLong(s, 2);
        int res = 0;
        while(num != 1){
            if(num % 2 == 0) num /= 2;
            else num +=1;
            res++;
        }
        return res;
    }
}

public class Solution {

    public int numSteps(String s) {
        int carry = 0;
        int res = 0;
        for(int i = s.length() - 1; i > 0; i--){
            int val = Character.getNumericValue(s.charAt(i)) + carry;
            if(val % 2 == 0) {
                res++;
            }
            else{
                res += 2;
                carry = 1;
            }
        }
        return res + carry;
    }
}
