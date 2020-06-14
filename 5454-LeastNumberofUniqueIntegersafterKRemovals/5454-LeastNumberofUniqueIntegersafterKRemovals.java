/*

5454. Least Number of Unique Integers after K Removals
Medium

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Example 2:

Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

    1 <= arr.length <= 10^5
    1 <= arr[i] <= 10^9
    0 <= k <= arr.length

*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //use pq
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int a : arr)
            map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            minHeap.add(entry.getKey());
        while(k-->0){
            if(minHeap.isEmpty()) break;
            int key = minHeap.poll();
            map.put(key, map.get(key) - 1);
            if(map.get(key) == 0)
                map.remove(key);
            else
                minHeap.add(key);
        }
        return minHeap.size();
    }
}
