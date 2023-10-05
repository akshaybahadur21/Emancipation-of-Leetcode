/*

229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]

Example 2:

Input: nums = [1]
Output: [1]

Example 3:

Input: nums = [1,2]
Output: [1,2]

Constraints:

    1 <= nums.length <= 5 * 104
    -109 <= nums[i] <= 109

 

Follow up: Could you solve the problem in linear time and in O(1) space?


*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        Queue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> map.get(n2) - map.get(n1));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.add(entry.getKey());
        }
        while(!heap.isEmpty()){
            int curr = heap.poll();
            if(map.get(curr) > nums.length / 3) resList.add(curr);
            else return resList;
        }
        return resList;
    }
}
