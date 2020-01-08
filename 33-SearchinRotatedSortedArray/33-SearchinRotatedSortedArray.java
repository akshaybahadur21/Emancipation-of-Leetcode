/*

33. Search in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/
class Solution {
    public int search(int[] nums, int target) {
        //using binary search, search for the lowest element
        //that will be your new low and use modulus concept
        
        int realLow = findRealLow(nums);
        int hi = nums.length-1;
        int lo =0;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            int realMid = (mid + realLow) % nums.length;
            if (nums[realMid] == target)
                return realMid;
            else if(nums[realMid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
        
    }
    private int findRealLow(int[] nums){
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = (lo+hi)/2;
            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
