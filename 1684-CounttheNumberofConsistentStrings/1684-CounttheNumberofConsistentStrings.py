"""

1684. Count the Number of Consistent Strings

You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

Constraints:

    1 <= words.length <= 104
    1 <= allowed.length <= 26
    1 <= words[i].length <= 10
    The characters in allowed are distinct.
    words[i] and allowed contain only lowercase English letters.

"""

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        _map = [0]*26
        res = 0
        for i in range(len(allowed)):  _map[ord(allowed[i]) - ord('a')] += 1
        for w in words:
            count = 0
            for i in range(len(w)):
                if _map[ord(w[i]) - ord('a')] > 0: count += 1
            res = res + 1 if count >= len(w) else res
        return res

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        mapp = {}
        for a in allowed: mapp[a] = mapp.get(a, 0) + 1
        res = 0
        for w in words:
            length = 0
            for ch in w:
                if ch not in mapp: break
                length += 1
            if length == len(w): res += 1
        return res
