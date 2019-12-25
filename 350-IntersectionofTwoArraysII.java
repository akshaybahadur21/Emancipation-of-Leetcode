/*
350. Intersection of Two Arrays II
Easy

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Link : https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/

*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //fill map with value and count
        //iterate 2nd array and check map and count
        // if the value is in Map and count>0, will add in result and decrease count
        Map<Integer, Integer> lookupMap = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        for (int i =0; i<nums1.length; i++)
            lookupMap.put(nums1[i], lookupMap.containsKey(nums1[i])? lookupMap.get(nums1[i])+1 :1);
        for (int i =0; i<nums2.length; i++){
            if (lookupMap.containsKey(nums2[i]) && lookupMap.get(nums2[i]) > 0){
                resList.add(nums2[i]);
                lookupMap.put(nums2[i], lookupMap.get(nums2[i]) -1);
            }
        }
        return resList.stream().mapToInt(Number::intValue).toArray();
    }
}
