/*

189. Rotate Array
Easy

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

Link : https://leetcode.com/problems/rotate-array/

*/

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length -1);
        reverseArray(nums, 0, k -1);
        reverseArray(nums, k, nums.length -1);
    }
    private void reverseArray(int[] nums, int start, int end){
        while(start < end){
            swap(nums , start, end);
            start ++;
            end --;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
    
}
