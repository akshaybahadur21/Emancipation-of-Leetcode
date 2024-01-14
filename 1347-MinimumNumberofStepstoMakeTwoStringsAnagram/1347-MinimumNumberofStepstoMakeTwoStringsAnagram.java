/*

1347. Minimum Number of Steps to Make Two Strings Anagram
Medium

You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 

Constraints:

    1 <= s.length <= 5 * 104
    s.length == t.length
    s and t consist of lowercase English letters only.

*/

class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);
            }
        }
        int res = 0;
        for(Character key : map.keySet()){
            res += map.get(key);
        }
        return res;
    }
}
