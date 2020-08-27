/*

115. Distinct Subsequences
Hard

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

*/

class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] cache = new Integer[s.length() + 1][t.length() + 1];
        return dfs(cache, s, t, 0, 0);
    }
    private int dfs(Integer[][] cache, String s, String t, int si, int ti){
        if(cache[si][ti] != null) return cache[si][ti];
        if(ti == t.length()) return 1;
        if(si == s.length() && ti < t.length()) return 0;
        int ways = 0;
        if(s.charAt(si) == t.charAt(ti))
            ways += dfs(cache, s, t, si + 1, ti + 1);
        ways += dfs(cache, s, t, si + 1, ti);
        cache[si][ti] = ways;
        return cache[si][ti];
    }
}
