/*

132. Palindrome Partitioning II
Hard

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0

Example 3:

Input: s = "ab"
Output: 1

Constraints:

    1 <= s.length <= 2000
    s consists of lower-case English letters only.

*/

class Solution {
    public int minCut(String s) {
        return dfs(s, 0, s.length() - 1, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    private int dfs(String s, int start, int end, int minCut, Integer[][] cache){
        if(start == end || isPalindrome(s, start, end)) return 0;
        if(cache[start][end] != null) return cache[start][end];
        for(int i = start; i <= end && minCut <= end; i++){
            if(isPalindrome(s, start, i)){
                minCut = Math.min(minCut, 1 + dfs(s, i + 1, end, minCut, cache));
            }
        }
        return cache[start][end] = minCut;
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
