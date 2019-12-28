/*

167. Two Sum II - Input array is sorted
Easy

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

*/

// Two pointer
class Solution {
    //Input array is sorted
    // p1 assigned to 0; p2 assigned to last
    // add nums[p1] and [p2] and increase p1 if sum is less than target or decrease p2 if sum is greater than target
    public int[] twoSum(int[] numbers, int target) {
        int[] nums = numbers;
        int[] res = new int[2];
        int p1 = 0;
        int p2 = nums.length -1;
        while (p1 != p2){
            if (nums[p1] + nums[p2] == target){
                res[0] = p1+1;
                res[1] = p2+1;
                break;
            }
            if (nums[p1] + nums[p2] > target){
                p2--;
                continue;
            }
            if (nums[p1]+nums[p2]< target){
                p1++;
                continue;
            }
        }
        return res;
    }
}
