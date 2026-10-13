"""

739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:

    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100

"""

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        res = [0] * len(temperatures)
        for i, t in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < t:
                prev_day = stack.pop()
                res[prev_day] = i - prev_day
            stack.append(i)
        return res
            
class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        res = [0] * len(temperatures)
        s = []
        for i, t in enumerate(temperatures):
            if not s:
                s.append([i, t])
            else:
                if t > s[-1][1]: # new temperature is bigger than previous
                    while s and s[-1][1] < t:
                        popped_i, popped_t = s.pop()
                        res[popped_i] = i - popped_i
                s.append([i, t])
        return res
