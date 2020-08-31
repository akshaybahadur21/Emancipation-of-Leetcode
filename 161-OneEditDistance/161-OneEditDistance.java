/*

161. One Edit Distance
Medium

Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

    Insert exactly one character into s to get t.
    Delete exactly one character from s to get t.
    Replace exactly one character of s with a different character to get t.

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.

Example 3:

Input: s = "a", t = ""
Output: true

Example 4:

Input: s = "", t = "A"
Output: true

Constraints:

    0 <= s.length <= 104
    0 <= t.length <= 104
    s and t consist of lower-case letters, upper-case letters and/or digits.

*/

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) return false;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }
            if (s.length() == t.length()) 
    			return s.substring(i + 1).equals(t.substring(j + 1));
			else if (s.length() < t.length())
				return s.substring(i).equals(t.substring(j + 1));	        	
			else
				return t.substring(j).equals(s.substring(i + 1));
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
