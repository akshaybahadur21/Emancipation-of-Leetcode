"""

767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"

Example 2:

Input: s = "aaab"
Output: ""

Constraints:

    1 <= s.length <= 500
    s consists of lowercase English letters.

"""

from heapq import heappush, heappop
from collections import Counter
class Solution:
    def reorganizeString(self, s: str) -> str:
        heap = []
        count = Counter(s)
        res = ['' for _ in range(len(s))]
        idx = 0
        for k, v in count.items(): heappush(heap, [-v, k])
        top = heappop(heap)
        if -top[0] > (len(s) + 1) // 2: return ""
        heappush(heap, top)
        while heap:
            top = heappop(heap)
            while top[0] != 0:
                res[idx] = top[1]
                top[0] += 1
                idx += 2
                if idx >= len(s): idx = 1
        return ''.join(res)
