/*

1052. Grumpy Bookstore Owner
Medium

Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

 

Note:

    1 <= X <= customers.length == grumpy.length <= 20000
    0 <= customers[i] <= 1000
    0 <= grumpy[i] <= 1

*/
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //Approach - sliding window for selecting when to use X
        // traverse before and after 
        
        //SOLUTION TAKES TIME
        
        int resMax = 0;
        int start = 0;
        int max = 0;
        while(start + X <= customers.length){
            //traverse before starting of sliding window
            for(int i = 0; i< start; i++)
                max += customers[i] * (grumpy[i] == 0 ? 1 : 0);
            
             //traverse sliding window
            for(int i = start; i< start + X; i++)
                max += customers[i];
            
             //traverse after end of sliding window
            for(int i = start + X ; i< customers.length; i++)
                max += customers[i] * (grumpy[i] == 0 ? 1 : 0);
            
            if (max > resMax)
                resMax = max;
            max = 0;
            start++;
            }
        return resMax;
    }
}
