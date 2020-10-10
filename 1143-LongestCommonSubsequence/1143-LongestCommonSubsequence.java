/*

1143. Longest Common Subsequence
Medium

Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.

*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        Integer[][] cache = new Integer[text1.length()][text2.length()];
        return dfs(text1, 0, text2, 0, cache);
    }
    private int dfs(String t1, int l1, String t2, int l2, Integer[][] cache){
        if(l1 >= t1.length() || l2 >= t2.length()) return 0;
        if(cache[l1][l2] != null) return cache[l1][l2];
        if(t1.charAt(l1) == t2.charAt(l2)) 
            return cache[l1][l2] = 1 + dfs(t1, l1 + 1, t2, l2 + 1, cache);
        return cache[l1][l2] = Math.max(dfs(t1, l1 + 1, t2, l2, cache), dfs(t1, l1, t2, l2 + 1, cache));
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        return dfs(text1, 0, text2, 0);
    }
    private int dfs(String t1, int l1, String t2, int l2){
        if(l1 >= t1.length() || l2 >= t2.length()) return 0;
        if(t1.charAt(l1) == t2.charAt(l2)) return 1 + dfs(t1, l1 + 1, t2, l2 +1 );
        return Math.max(dfs(t1, l1 + 1, t2, l2), dfs(t1, l1, t2, l2 + 1));
    }
}
