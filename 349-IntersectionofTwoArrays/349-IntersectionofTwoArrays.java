/*
349. Intersection of Two Arrays
Easy

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

    Each element in the result must be unique.
    The result can be in any order.

Link : https://leetcode.com/problems/intersection-of-two-arrays/submissions/

*/

class Solution {
    //iterate through the first array and add it to set
    //iterate through 2nd array and check if it is in the set already.
    //add unique values for returning
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resSet = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        for ( int i = 0; i<nums1.length; i++)
            tempSet.add(nums1[i]);
        for ( int i = 0; i<nums2.length; i++){
            if (tempSet.contains(nums2[i]))
                resSet.add(nums2[i]);
        }
        return resSet.stream().mapToInt(Number::intValue).toArray();
    }
}
class Solution {
    //Sort both arrays.
    // Take 2 pointers and compare
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ansList = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int count =0;
        while(p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] > nums2[p2]){
                p2++; continue;
            }
            if (nums1[p1] < nums2[p2]){
                p1++; continue;
            }
            if(nums1[p1] == nums2[p2]){
                if (count == 0){
                    ansList.add(nums1[p1]);
                    count++;
                }
                else if(ansList.get(count-1) != nums1[p1]){
                    ansList.add(nums1[p1]);
                    count++;
                }
                p1++;
                p2++;
                
            }
        }
        return ansList.stream().mapToInt(Number::intValue).toArray();
    }
}

