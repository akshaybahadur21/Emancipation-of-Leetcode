/*

922. Sort Array By Parity II
Easy

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Example 2:

Input: nums = [2,3]
Output: [2,3]

Constraints:

    2 <= nums.length <= 2 * 104
    nums.length is even.
    Half of the integers in nums are even.
    0 <= nums[i] <= 1000

*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        for(int even = 0; even < nums.length; even += 2){
            if(nums[even] % 2 == 1){
                while(nums[odd] % 2 == 1) 
                    odd += 2;
                int tmp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = tmp;
            }
        }
        return nums;
    }
}
