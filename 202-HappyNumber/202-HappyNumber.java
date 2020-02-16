/*

202. Happy Number
Easy

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

*/

class Solution {
    public boolean isHappy(int n) {
        //we know when n =1 or n=7, it is a happy number, therefore we return happy
        // otherwise, we return false for 1 digit number
        if (n == 7) return true;
        if (n == 1) return true;
        
        if (n < 10 && n != 1) return false;
        int sumSquare = 0;
        while (n != 0){
            int mod = n%10;
            sumSquare += mod*mod;
            n = n/10;
        }
        return isHappy(sumSquare);
    }
}
