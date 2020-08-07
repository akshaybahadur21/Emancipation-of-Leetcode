/*

34. Find First and Last Position of Element in Sorted Array
Medium

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non decreasing array.
    -10^9 <= target <= 10^9

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
       // binary search twice
        int[] res = new int[]{-1 , -1};
        if(!validateInput(nums, target)) return res;
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < target)  lo = mid + 1;
            else hi = mid;
        }
        if(nums[lo] != target) return res;
        res[0] = lo;
        hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2 + 1;
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        res[1] = lo;
        return res;
    }
    private boolean validateInput(int[] nums, int target) {
        if(nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) return false;
        return true;
    }
}
