/*

5. Longest Palindromic Substring
Medium

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

*/

class Solution {
    int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i =0; i < s.length(); i++){
            extendPalindrom(s, i, i);
            extendPalindrom(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrom(String s, int j, int i){
        while( j>=0 && i<s.length() && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if (maxLen < i - j -1){
            lo = j + 1;
            maxLen = i - j -1;
        }
        
        
    }
}
