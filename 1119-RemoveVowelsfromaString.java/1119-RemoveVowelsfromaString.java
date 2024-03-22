/*

1119. Remove Vowels from a String
Easy

Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

Example 1:

Input: s = "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:

Input: s = "aeiou"
Output: ""

Constraints:

    1 <= s.length <= 1000
    s consists of only lowercase English letters.

*/

class Solution {
    public String removeVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(!set.contains(ch)) sb.append(ch);
        }
        return sb.toString();
    }
}
