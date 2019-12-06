/*

169. Majority Element
Easy

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

Link : https://leetcode.com/problems/majority-element/submissions/

*/

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==0)
            return 0;
        Map<Integer, Integer> lookupMap = new HashMap<>();
        for (int i=0;i<nums.length;i++)
            lookupMap.put(nums[i],lookupMap.containsKey(nums[i])?lookupMap.get(nums[i])+1:1);
        Queue<Integer> heap = new PriorityQueue<Integer>((n1,n2)->lookupMap.get(n1)-lookupMap.get(n2));
        for(Map.Entry<Integer, Integer> entry : lookupMap.entrySet()){
            heap.add(entry.getKey());
            if (heap.size()>1)
                heap.remove();
        }
        return heap.poll();
    }
}
