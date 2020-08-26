/*

91. Decode Ways
Medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

*/

class Solution {
    public int numDecodings(String s) {
       if(s == null || s.length() == 0 || s.equals("0")) return 0;
        Integer[] cache = new Integer[s.length()];
        return dfs(cache, s, 0);
    }
    private int dfs(Integer[] cache, String s, int idx){
        if(idx == s.length()) return 1;
        if(cache[idx] != null) return cache[idx];
        int ans = 0;
        int c1 = Character.getNumericValue(s.charAt(idx));
        if(c1 >= 1) ans = dfs(cache, s, idx + 1);
        if(idx + 1 < s.length()){
            int c2 = Character.getNumericValue(s.charAt(idx + 1));
            if(c1 == 1 || c1 == 2 && c2 <= 6) ans += dfs(cache, s, idx + 2);
        }
        cache[idx] = ans;
        return cache[idx];
    }
}

class Solution {
    public int numDecodings(String s) {
       if(s == null || s.length() == 0 || s.equals("0")) return 0;
        Integer[] cache = new Integer[s.length()];
        return dfs(cache, s, 0);
    }
    private int dfs(Integer[] cache, String s, int idx){
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(idx == s.length() - 1) return 1;
        if(cache[idx] != null) return cache[idx];
        int a1 = dfs(cache, s, idx + 1); // move to next index;
        if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
             a1 += dfs(cache, s, idx + 2);
        cache[idx] = a1;
        return cache[idx];
    }
}
