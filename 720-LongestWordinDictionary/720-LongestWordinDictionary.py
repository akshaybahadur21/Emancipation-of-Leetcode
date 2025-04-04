"""

720. Longest Word in Dictionary

Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Constraints:

    1 <= words.length <= 1000
    1 <= words[i].length <= 30
    words[i] consists of lowercase English letters.

"""

class TNode:
    def __init__(self):
        self.children = {}
class Solution:
    def longestWord(self, words: List[str]) -> str:
        root = TNode()
        words = sorted(words, key = lambda x : (len(x), x))
        res = ""
        def insert(word):
            temp = root
            for i, ch in enumerate(word):
                if ch not in temp.children and i != len(word) - 1: return ''
                if ch not in temp.children:
                    temp.children[ch] = TNode()
                temp = temp.children[ch]
            return word
            
        for word in words:
            val = insert(word)
            if len(val) > len(res): res = val
        return res
