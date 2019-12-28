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
// Using 2 pointers
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] numsCopy = new int[nums.length];
        for (int i =0; i<nums.length; i++){
            numsCopy[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] temp = new int[2];
        int[] res = new int[2];
        int p1 = 0;
        int p2 = nums.length -1;
        while (p1 != p2){
            if (nums[p1] + nums[p2] == target){
                temp[0] = nums[p1];
                temp[1] = nums[p2];
                break;
            }
            if (nums[p1] + nums[p2] > target){
                p2--;
                continue;
            }
            if (nums[p1]+nums[p2]< target){
                p1++;
                continue;
            }
        }
        int count = 0;
        for (int i =0; i<numsCopy.length; i++){
            if (numsCopy[i] == temp[0]){
                res[count] = i;
                count++;
                continue;
            }
            if ( numsCopy[i] == temp[1]){
                res[count] = i;
                count++;
                continue;
            }
            if (count == 2)
                return res;
                
        }
        return res;
    }
}
}
