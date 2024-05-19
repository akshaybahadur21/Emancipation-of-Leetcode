"""

1197. Minimum Knight Moves

In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]

Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

Constraints:

    -300 <= x, y <= 300
    0 <= |x| + |y| <= 300

"""


class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        offsets = [(1, 2), (2, 1), (2, -1), (1, -2),
                   (-1, -2), (-2, -1), (-2, 1), (-1, 2)]
        
        def bfs(i, j):
            q = deque([(i, j)])
            vis = set()
            res = 0

            while len(q) > 0:
                length = len(q)
                for i in range(length):
                    curr = q.popleft()
                    if (curr[0], curr[1]) == (x, y):
                        return res
                    for next_step in offsets:
                        next_x, next_y = curr[0] + next_step[0], curr[1] + next_step[1]
                        if(next_x, next_y) not in vis:
                            vis.add((next_x, next_y))
                            q.append((next_x, next_y))
                res += 1

        return bfs(0, 0)
        
