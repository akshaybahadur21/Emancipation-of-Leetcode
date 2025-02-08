"""

281. Zigzag Iterator

Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.

Implement the ZigzagIterator class:

    ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
    boolean hasNext() returns true if the iterator still has elements, and false otherwise.
    int next() returns the current element of the iterator and moves the iterator to the next element.

Example 1:

Input: v1 = [1,2], v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].

Example 2:

Input: v1 = [1], v2 = []
Output: [1]

Example 3:

Input: v1 = [], v2 = [1]
Output: [1]

Constraints:

    0 <= v1.length, v2.length <= 1000
    1 <= v1.length + v2.length <= 2000
    -231 <= v1[i], v2[i] <= 231 - 1

Follow up: What if you are given k vectors? How well can your code be extended to such cases?

Clarification for the follow-up question:

The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Follow-up Example:

Input: v1 = [1,2,3], v2 = [4,5,6,7], v3 = [8,9]
Output: [1,4,8,2,5,9,3,6,7]

"""

class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.q1 = deque(v1)
        self.q2 = deque(v2)
        self.one= True

    def next(self) -> int:
        if not self.q1: return self.q2.popleft()
        if not self.q2: return self.q1.popleft()

        if self.one:
            self.one = False
            return self.q1.popleft()
        else:
            self.one = True
            return self.q2.popleft()

    def hasNext(self) -> bool:
        return len(self.q1) > 0 or len(self.q2)

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())
