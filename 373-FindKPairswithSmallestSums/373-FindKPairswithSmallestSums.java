/*

373. Find K Pairs with Smallest Sums
Medium

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // create a heap to keep a track of the k pairs
        List<List<Integer>> resList = new ArrayList<>();
        Queue<int[]> heap = new PriorityQueue<>((n1,n2) -> (n2[0] + n2[1]) - (n1[0] + n1[1])); //max heap
        for (int i = 0; i<nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                heap.add(new int[]{nums1[i], nums2[j]});
                if (heap.size() > k)
                    heap.poll();
            }
        }
        while(!heap.isEmpty()){
            int[] temp = heap.poll();
            List<Integer> tempList = new ArrayList<>();
            tempList.add(temp[0]);
            tempList.add(temp[1]);
            resList.add(tempList);
        }
        return resList;
    }
}

