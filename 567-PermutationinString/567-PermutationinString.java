/*

567. Permutation in String
Medium

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:

    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(!validateInput(s1, s2)) return false;
        int[] map = new int[26];
        for(char ch : s1.toCharArray())
            map[ch - 'a']++;
        int count = s1.length();
        for(int i =0; i < s2.length(); i++){
            int ch = s2.charAt(i);
            map[ch - 'a']--;
            if(map[ch - 'a'] >= 0)
                count--;
            if (i - s1.length() >=0){
                if(map[s2.charAt(i - s1.length()) - 'a'] >= 0)
                    count++;
                map[s2.charAt(i - s1.length()) - 'a']++;
            }
            if(count == 0) return true;
        }
        return false;
    }
    private boolean validateInput(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() > s2.length() || s1.length() == 0 && s2.length() == 0)
            return false;
        return true;
    }
}
