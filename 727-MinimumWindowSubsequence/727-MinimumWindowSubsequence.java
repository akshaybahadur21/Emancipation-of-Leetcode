/*

727. Minimum Window Subsequence
Hard

Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.

Note:

    All the strings in the input will only contain lowercase letters.
    The length of S will be in the range [1, 20000].
    The length of T will be in the range [1, 100].

*/

class Solution {
    public String minWindow(String S, String T) {
        Integer[][] cache = new Integer[S.length()][T.length()];
        String res = "";
        for(int i = 0; i < S.length(); i++){
            if (S.charAt(i) != T.charAt(0)) continue;
            int len = dfs(cache, S, i + 1, T, 1);
            if(len == -1 || (res.length() != 0 && res.length() <= 1 + len)) continue;
            res = S.substring(i, i + len + 1);
        }
        return res;
    }
    private int dfs(Integer[][] cache, String s, int si, String t, int ti){
        if(ti == t.length()) return 0;
        if(si == s.length()) return -1;
        if(cache[si][ti] != null) return cache[si][ti];
        if(s.charAt(si) == t.charAt(ti)){
            int l1 = dfs(cache, s, si + 1, t, ti + 1);
            return cache[si][ti] = l1 == -1 ? -1 : 1 + l1;
        }
        else{
            int l2 = dfs(cache, s, si + 1, t, ti);
            return cache[si][ti] = l2 == -1 ? -1 : 1 + l2;
        }
    }
}
