/*

238. Product of Array Except Self
Medium

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int countZeros = 0;
        for (int i : nums){
            if (i == 0)
                countZeros++;
            else
                prod *= i;
        }
        int[] res = new int[nums.length];
        if (countZeros > 1) return res;
        for (int i = 0; i < nums.length; i++){
            if (countZeros == 1){
                if (nums[i] == 0){
                    res[i] = prod;
                    return res;
                }
            }
            else{
            res[i] = prod / nums[i];
            }
        }
        return res;
    }
}
