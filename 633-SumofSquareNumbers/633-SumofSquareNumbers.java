/*

633. Sum of Square Numbers
Easy

Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

Input: 3
Output: False

*/

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c <= 1) return true;
        int lo  = 0;
        int hi = (int)Math.sqrt(c);
        while(lo <= hi){
            if (lo*lo + hi*hi == c)
                return true;
            if (lo*lo + hi*hi > c)
                hi--;
            else
                lo++;
        }
        return false;
    }
}
