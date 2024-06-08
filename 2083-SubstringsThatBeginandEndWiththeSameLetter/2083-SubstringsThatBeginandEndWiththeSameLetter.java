/*

2083. Substrings That Begin and End With the Same Letter

You are given a 0-indexed string s consisting of only lowercase English letters. Return the number of substrings in s that begin and end with the same character.

A substring is a contiguous non-empty sequence of characters within a string.

Example 1:

Input: s = "abcba"
Output: 7
Explanation:
The substrings of length 1 that start and end with the same letter are: "a", "b", "c", "b", and "a".
The substring of length 3 that starts and ends with the same letter is: "bcb".
The substring of length 5 that starts and ends with the same letter is: "abcba".

Example 2:

Input: s = "abacad"
Output: 9
Explanation:
The substrings of length 1 that start and end with the same letter are: "a", "b", "a", "c", "a", and "d".
The substrings of length 3 that start and end with the same letter are: "aba" and "aca".
The substring of length 5 that starts and ends with the same letter is: "abaca".

Example 3:

Input: s = "a"
Output: 1
Explanation:
The substring of length 1 that starts and ends with the same letter is: "a".

Constraints:

    1 <= s.length <= 105
    s consists only of lowercase English letters.

*/

class Solution {

    public long numberOfSubstrings(String s) {
        int n = s.length();
        long answer = 0;
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            answer += map[s.charAt(i) - 'a'];
        }

        return answer;
    }
}
