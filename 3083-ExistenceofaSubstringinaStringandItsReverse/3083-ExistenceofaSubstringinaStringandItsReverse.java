/*

3083. Existence of a Substring in a String and Its Reverse
Easy

Given a string s, find any substring of length 2 which is also present in the reverse of s.

Return true if such a substring exists, and false otherwise.

Example 1:

Input: s = "leetcode"

Output: true

Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

Example 2:

Input: s = "abcba"

Output: true

Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".

Example 3:

Input: s = "abcd"

Output: false

Explanation: There is no substring of length 2 in s, which is also present in the reverse of s.

Constraints:

    1 <= s.length <= 100
    s consists only of lowercase English letters.

*/

class Solution {
    public boolean isSubstringPresent(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            sb.append(s.charAt(i));
            set.add(sb.toString());
            sb.deleteCharAt(0);
        }
        sb = new StringBuilder();
        sb.append(s.charAt(s.length() - 1));
        for(int i = s.length() - 2; i >= 0; i--){
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())) return true;
            sb.deleteCharAt(0);
        }
        return false;
    }
}
