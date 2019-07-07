/***
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Author : Akshay Bahadur
Date : 7th July, 2019

***/

// O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sol[]=new int[2];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if (nums[i]+nums[j] == target)
                {
                    sol[0]=i;
                    sol[1]=j;
                    return sol;
                }
            }
        }
     return null;
    }
}

// O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> lookupMap=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            int diff=target-nums[i];
            if (lookupMap.containsKey(diff))
                return new int[]{lookupMap.get(diff),i};
            lookupMap.put(nums[i],i);
        }
        return null;
}
}
