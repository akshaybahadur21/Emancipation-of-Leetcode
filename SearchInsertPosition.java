/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 4:

Input: [1,3,5,6], 0
Output: 0

Question Link : https://leetcode.com/problems/search-insert-position/

*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low =0;
        int high=nums.length;
        int mid=0;
        int temp=0;
        
        if (target<nums[0])
            return 0;
        if (target>nums[nums.length-1])
            return nums.length;
        
        while(low<=high)
        {
            mid= low+(high-low)/2;
            if (nums[mid] == target)
                return mid;
            
            if(target > nums[mid])
            {
                low =mid+1;
                temp =low;
            }
            else
            {
                high=mid-1;
                temp=high+1;
            }
            
        }
        return temp;
    }
}
