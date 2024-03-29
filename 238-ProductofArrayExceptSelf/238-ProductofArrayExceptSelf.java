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
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1, count = 0;
        for(int n : nums){
            if(n != 0)
                mul = mul * n;
            if(n == 0) count++;
        }
        int res[] = new int[nums.length];
        if(count >= 2) return res;
        for(int i = 0; i < nums.length; i++){
            if(count == 1 && nums[i] == 0) res[i] = mul;
            else if(count == 1 && nums[i] != 0) res[i] = 0;
            else res[i] = mul/nums[i];
        }
        return res;
    }
}
