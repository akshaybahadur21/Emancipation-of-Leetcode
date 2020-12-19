/*

1493. Longest Subarray of 1's After Deleting One Element
Medium

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.

Return 0 if there is no such subarray.

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Example 4:

Input: nums = [1,1,0,0,1,1,1,0,1]
Output: 4

Example 5:

Input: nums = [0,0,0]
Output: 0

Constraints:

    1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.

*/

class Solution {
    public int longestSubarray(int[] nums) {
        //sliding window to maintain atmost one 0.
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(!map.containsKey(nums[i])) 
                    map.put(nums[i], i);
                else{
                    res = Math.max(res, i - start - 1);
                    start = map.get(nums[i]) + 1;
                    map.put(nums[i], i);
                }
            }
        }
        return Math.max(res, nums.length - start - 1);
    }
}
