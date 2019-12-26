/*

164. Maximum Gap
Hard

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:

    You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
    Try to solve it in linear time/space.

Link : https://leetcode.com/problems/maximum-gap/submissions/

*/

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        
        Queue<Integer> heap = new PriorityQueue<>((n1,n2)->n2-n1);
        for (int i =0; i< nums.length; i++)
            heap.add(nums[i]);
        
        int max =0;
        while(heap.size() > 1){
            int diff = heap.poll() - heap.peek();
            if (diff>max)
                max = diff; 
            }
        return max;
    }
}
