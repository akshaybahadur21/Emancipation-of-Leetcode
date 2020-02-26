/*

239. Sliding Window Maximum
Hard

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

*/

class Solution {
//Currently O(n * k)
//need to optimize for O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i <= nums.length - k){
            int temp = nums[i];
            for (int j = i+1; j < i+k; j++)
                temp = Math.max(temp, nums[j]);
            res.add(temp);
            i++;
            }
        return res.stream().mapToInt(a -> a).toArray();
    }
}
