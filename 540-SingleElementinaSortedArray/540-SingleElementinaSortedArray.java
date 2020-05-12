/*

540. Single Element in a Sorted Array
Medium

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10

*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        //simple 2pointer approach
        for(int i = 0; i< nums.length - 1; i = i + 2){
            if(nums[i] != nums[i + 1])
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if((hi - mid) % 2 == 0){
            if(nums[mid] == nums[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
                
            }
            else{
                if(nums[mid] != nums[mid - 1])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
                
        }
        return nums[lo];
    }
}
