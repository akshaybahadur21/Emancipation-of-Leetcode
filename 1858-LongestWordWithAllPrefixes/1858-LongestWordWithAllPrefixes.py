"""

1858. Longest Word With All Prefixes

Given an array of strings words, find the longest string in words such that every prefix of it is also in words.

    For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.

Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".

Example 1:

Input: words = ["k","ki","kir","kira", "kiran"]
Output: "kiran"
Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of them appear in words.

Example 2:

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: Both "apple" and "apply" have all their prefixes in words.
However, "apple" is lexicographically smaller, so we return that.

Example 3:

Input: words = ["abc", "bc", "ab", "qwe"]
Output: ""

Constraints:

    1 <= words.length <= 105
    1 <= words[i].length <= 105
    1 <= sum(words[i].length) <= 105

"""

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
    def longestWord(self, words: List[str]) -> str:
        root = TrieNode()
        
        def insertInTrie(word):
            curr = root
            for ch in word:
                if ch not in curr.children: curr.children[ch] = TrieNode()
                curr = curr.children[ch]
            curr.isEnd = True

        for word in words: insertInTrie(word)
        res = ""
        
        def findAllPrefix(word):
            curr = root
            for ch in word:
                if ch not in curr.children or not curr.children[ch].isEnd: return False
                curr = curr.children[ch]
            return curr.isEnd

        for word in words:
            if findAllPrefix(word):
                if len(word) > len(res) or (
                    len(word) == len(res)
                    and word < res
                ):
                    res = word
        return res
        
