/*

162. Find Peak Element
Medium

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.

Note:

Your solution should be in logarithmic complexity.

*/

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length < 2) return 0;
        int max = 0;
        for(int i = 1; i < nums.length -1; i++){
            if(nums[i - 1] < nums[i] && nums[i + 1] < nums[i])
                return i;
            if (nums[max] < nums[i])
                max = i;
        }
        if (nums[max] < nums[0])
                max = 0;
        if (nums[max] < nums[nums.length - 1])
                max = nums.length - 1;
      return max;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
