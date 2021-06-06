/*

760. Find Anagram Mappings
Easy

Given two lists nums1 and nums2, and nums2 is an anagram of nums1. nums2 is an anagram of nums1 means nums2 is made by randomizing the order of the elements in nums1.

We want to find an index mapping mapping, from nums1 to nums2. A mapping mapping[i] = j means the ith element in nums1 appears in nums2 at index j.

These lists nums1 and nums2 may contain duplicates. If there are multiple answers, output any of them.

For example, given

nums1 = [12, 28, 46, 32, 50]
nums2 = [50, 12, 32, 46, 28]

We should return

[1, 4, 3, 2, 0]

as mapping[0] = 1 because the 0th element of nums1 appears at nums2[1], and mapping[1] = 4 because the 1st element of nums1 appears at nums2[4], and so on.

Note:

    nums1, nums2 have equal lengths in range [1, 100].
    nums1[i], nums2[i] are integers in range [0, 10^5].

*/

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        int count = 0;
        for(int n : nums1) res[count++] = map.get(n);
        return res;
    }
}
