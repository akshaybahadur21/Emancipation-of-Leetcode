/*

41. First Missing Positive
Hard

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Note:

Your algorithm should run in O(n) time and uses constant extra space.

Link : https://leetcode.com/problems/first-missing-positive/

*/

//HashMap
class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> lookupMap = new LinkedHashMap<>();
        for (int i =1; i <= nums.length; i++)
                lookupMap.put(i,0);
        
        for (int i = 0; i< nums.length; i++){
            if (lookupMap.containsKey(nums[i]))
                lookupMap.put(nums[i] , lookupMap.get(nums[i])+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : lookupMap.entrySet()){
            if(entry.getValue() == 0)
                return entry.getKey();
        }
        return nums.length+1;
    }
}

//HashSet
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> lookupSet = new HashSet<>();
        int countPos = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]>0){
                countPos++;
            lookupSet.add(nums[i]);
            }
        }
        
        for(int i =1; i<= countPos; i++){
            if(!lookupSet.contains(i))
                return i;
        }
        return countPos + 1;
    }
}
