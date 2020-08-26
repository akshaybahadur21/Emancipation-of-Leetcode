/*

639. Decode Ways II
Hard

A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:

Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

Example 2:

Input: "1*"
Output: 9 + 9 = 18

Note:

    The length of the input string will fit in range [1, 105].
    The input string will only contain the character '*' and digits '0' - '9'.

*/

class Solution {
    int mod = 1000000007;
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
        if(c1 == -1) ans = 9 * dfs(cache, s, idx + 1);
        else if(c1 >= 1) ans = dfs(cache, s, idx + 1);
        if(idx + 1 < s.length()){
            int c2 = Character.getNumericValue(s.charAt(idx + 1));
            if(c1 == -1 && c2 == -1) ans += 15 * dfs(cache, s, idx  + 2);
            else if(c1 == 1 && c2 == -1) ans += 9 * dfs(cache, s, idx + 2);
            else if(c1 == 2 && c2 == - 1) ans += 6 * dfs(cache, s, idx + 2);
            else if(c1 == 1 || c1 == 2 && c2 <= 6) ans += dfs(cache, s, idx + 2);
            else if(c1 == -1 && c2 <= 6) ans += 2 * dfs(cache, s, idx + 2);
            else if (c1 == -1) ans += dfs(cache, s, idx + 2);
        }
        cache[idx] = ans % mod;
        return cache[idx];
    }
}
