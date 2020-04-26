/*

69. Sqrt(x)
Easy

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2

Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 3) return 1;
        int lo = 1, hi = x/2;
        while(hi >= lo){
            int mid = lo + (hi - lo) / 2;
            if(mid == x/mid || (mid < x/mid && (mid + 1) > x / (mid + 1)))
               return mid;
            else if (x/mid > mid)
               lo = mid + 1;
            else   
                hi  = mid - 1;
        }
        return -1;
    }
}
