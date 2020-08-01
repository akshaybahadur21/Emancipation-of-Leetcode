/*

516. Longest Palindromic Subsequence
Medium

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:
"cbbd"

Output:
2
One possible longest palindromic subsequence is "bb".

Constraints:

    1 <= s.length <= 1000
    s consists only of lowercase English letters.

*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1);
    }
    private int dfs(String s, int lo, int hi){
        if(lo > hi) return 0;
        if(lo == hi) return 1;
        if(s.charAt(lo) == s.charAt(hi)) return 2 + dfs(s, lo + 1, hi - 1);
        int c1 = dfs(s, lo + 1, hi);
        int c2 = dfs(s, lo, hi - 1);
        return Math.max(c1, c2);
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    private int dfs(String s, int lo, int hi, Integer[][] cache){
        if(lo > hi) return 0;
        if(lo == hi) return 1;
        if(cache[lo][hi] != null) return cache[lo][hi];
        if(s.charAt(lo) == s.charAt(hi)) return 2 + dfs(s, lo + 1, hi - 1, cache);
        int c1 = dfs(s, lo + 1, hi, cache);
        int c2 = dfs(s, lo, hi - 1, cache);
        cache[lo][hi] = Math.max(c1, c2);
        return cache[lo][hi];
    }
}
