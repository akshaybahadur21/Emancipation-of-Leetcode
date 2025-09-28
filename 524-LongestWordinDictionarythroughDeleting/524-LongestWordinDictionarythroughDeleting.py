"""

524. Longest Word in Dictionary through Deleting

Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"

Constraints:

    1 <= s.length <= 1000
    1 <= dictionary.length <= 1000
    1 <= dictionary[i].length <= 1000
    s and dictionary[i] consist of lowercase English letters.

"""

class TNode:
    def __init__(self):
        self.children = defaultdict(TNode)
        self.end = False

class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        def insert(word):
            curr = root
            for ch in word:
                curr.children[ch] = TNode()
                curr = curr.children[ch]
            curr.end = True
            return root
        def search(word):
            curr = root
            res = ""
            for ch in word:
                if ch not in curr.children: continue
                res += ch
                curr = curr.children[ch]
                if curr.end: return res
            return ""

        res = ""
        root = TNode()
        for word in dictionary:
            root = insert(word)
            curr = search(s)
            if curr == word:
                if len(word) > len(res): res = word
                elif len(word) == len(res) and word < res: res = word
            root = TNode()
        return res

        
