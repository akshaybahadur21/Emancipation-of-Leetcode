/*

136. Single Number
Easy

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4

Link : https://leetcode.com/problems/single-number/

*/

class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> lookupMap = new HashMap<>();
        for (int i=0;i<nums.length;i++)
            lookupMap.put(nums[i],lookupMap.containsKey(nums[i]) ? lookupMap.get(nums[i]) + 1 : 1);
        
        for (Map.Entry<Integer, Integer> entry : lookupMap.entrySet()) {
            if(entry.getValue()==1)
                return entry.getKey();
        }
        
        return 0;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums)
            xor = xor ^ n;
        return xor;
    }
}
