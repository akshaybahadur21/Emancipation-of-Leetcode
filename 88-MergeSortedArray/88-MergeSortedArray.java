/*

88. Merge Sorted Array
Easy

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m -1;
        int i = m - 1;
        int j = n - 1;
        while(k>=0){
            if (i == -1 || j == -1) break;
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        int val = i == -1 ? j : i;
        int[]nums = i == -1 ? nums2 : nums1;
        while(k>=0){
            nums1[k--] = nums[val--];
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int hi = m + n - 1;
        m--;
        n--;
        while(hi >= 0){
            int n1 = m < 0 ? Integer.MIN_VALUE : nums1[m];
            int n2 = n < 0 ? Integer.MIN_VALUE : nums2[n];
            if(n1 > n2) nums1[hi--] = nums1[m--];
            else nums1[hi--] = nums2[n--];
        }
    }
}
