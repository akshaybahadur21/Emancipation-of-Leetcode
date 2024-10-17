"""

670. Maximum Swap

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.

Constraints:

    0 <= num <= 108

"""

class Solution:
    def maximumSwap(self, num: int) -> int:
        heap = []
        res = list(str(num))
        for i, ch in enumerate(res): heappush(heap, (-int(ch), -i, i))
        is_end = False
        while heap and not is_end:
            maxx, _, idx = heappop(heap)
            maxx = -maxx
            for i, digit in enumerate(res):
                if maxx > int(digit):
                    temp = res[i]
                    res[i] = str(maxx)
                    res[idx] = temp
                    is_end = True
                    break
                if idx == i: break
        return int("".join(res))
