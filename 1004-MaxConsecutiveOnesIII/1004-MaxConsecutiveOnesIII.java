/*

1004. Max Consecutive Ones III
Medium

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
    0 <= k <= nums.length

*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int curr = 0, max = 0, j = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                q.add(nums[j]);
                j++;
                max = Math.max(max, q.size());
                continue;
            }
            if(nums[j] == 0){
                if(curr < k){
                    q.add(nums[j]);
                    curr++;
                    max = Math.max(max, q.size());
                    j++;
                }
                else if(curr == k){
                    if(q.isEmpty()) {
                        j++;
                        continue;
                    }
                    while(!q.isEmpty() && q.peek()!= 0) q.pollFirst();
                    if(q.isEmpty()) {
                        j++;
                        continue;
                    }
                    q.poll();
                    curr--;
                }
            }
        }
        return Math.max(max, q.size());
    }
}
