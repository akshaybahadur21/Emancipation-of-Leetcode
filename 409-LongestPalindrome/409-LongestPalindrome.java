/*

409. Longest Palindrome
Easy

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        if(!validateInput(s)) return res;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            res += entry.getValue() / 2;
        return res * 2 == s.length() ? res * 2 : res * 2 + 1;
    }
    private boolean validateInput(String s){
        if(s == null || s.length() == 0) return false;
        return true;
    }
}
