"""

1229. Meeting Scheduler

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]

Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []

Constraints:

    1 <= slots1.length, slots2.length <= 104
    slots1[i].length, slots2[i].length == 2
    slots1[i][0] < slots1[i][1]
    slots2[i][0] < slots2[i][1]
    0 <= slots1[i][j], slots2[i][j] <= 109
    1 <= duration <= 106

"""

class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        slots1 = sorted(slots1, key=lambda x : x[0])
        slots2 = sorted(slots2, key=lambda x : x[0])
        i, j = 0, 0
        while i < len(slots1) and j < len(slots2):
            s1 = slots1[i]
            s2 = slots2[j]
            if s1[1] >= s2[0]:
                minn = min(s1[1], s2[1])
                maxx = max(s1[0], s2[0])
                if minn - maxx >= duration: return [maxx, maxx + duration]
            if s1[1] > s2[1]: j+= 1
            else: i += 1
        return []
