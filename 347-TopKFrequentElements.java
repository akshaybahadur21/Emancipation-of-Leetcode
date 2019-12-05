/*

347. Top K Frequent Elements
Medium

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Link : https://leetcode.com/problems/top-k-frequent-elements/

*/



class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        if (nums.length==0)
            return null;
        
        HashMap<Integer, Integer> lookupMap = new HashMap();
        for (int n: nums) {
          lookupMap.put(n, lookupMap.containsKey(n)?lookupMap.get(n)+1:1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, (n1, n2) -> lookupMap.get(n2) - lookupMap.get(n1));
        
        for (int n: lookupMap.keySet())
          heap.add(n);
        
        List<Integer> resultList = new ArrayList();
        for (int i=0;i<k;i++)
            resultList.add(heap.poll());

        return resultList;
    }
}
