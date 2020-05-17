/*

76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

*/

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || s == null || s.length() == 0) return "";
        int left = 0, right = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int len = t.length();
        int map[] = new int[128];
        for(char ch : t.toCharArray())
            map[ch]++;
        while(right < s.length()){
            if(map[s.charAt(right)] > 0)
                len--;
            map[s.charAt(right)]--;
            right++;
            while(len == 0){
                if(minLen > right - left){
                    minStart = left;
                    minLen = right - left;
                }
                map[s.charAt(left)]++;
                if(map[s.charAt(left)] > 0)
                    len++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
