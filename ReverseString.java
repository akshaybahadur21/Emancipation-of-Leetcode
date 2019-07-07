/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Question : https://leetcode.com/problems/reverse-integer/
**/

class Solution {
    public int reverse(int x) {
        if (x<0)
            return -(rev_check(x));
        return rev_check(x);
    }
    
    public static int rev_check(int x)
    {
        x=Math.abs(x);
        int rev=0;
        int num=x;
        while (num!=0)
        {
            int rem=num%10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && rem > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem < -8)) return 0;
            rev=rev*10+rem;
            num=num/10;
        }
        return rev;
}
    }
