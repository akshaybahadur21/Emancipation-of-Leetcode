/*

367. Valid Perfect Square
Easy

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true

Example 2:

Input: 14
Output: false


*/

class Solution {
    public boolean isPerfectSquare(int num) {
        //Couple of Approach
        //1. Brute Force (check every number) or optimise it a bit.
        //2. binary search approach
        if (num == 1)
            return true;
        for (int i =0 ; i<= num/2; i++){
            if (i * i == num)
                return true;
        }
        return false;
        
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        //Couple of Approach
        //1. Brute Force (check every number) or optimise it a bit.
        //2. binary search approach
        if (num == 1) return true;
        if (num == 0) return false;
        long lo = 2;
        long hi = num/2;
        while(lo<=hi){
            long mid = lo + (hi - lo)/2;
            if (mid * mid == num)
                return true;
            if (mid * mid > num)
                hi = mid-1;
            else
                lo = mid+1;
        }
       return false; 
    }
}
