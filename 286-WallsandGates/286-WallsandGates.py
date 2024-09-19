"""

286. Walls and Gates

You are given an m x n grid rooms initialized with these three possible values.

    -1 A wall or an obstacle.
    0 A gate.
    INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example 1:

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

Example 2:

Input: rooms = [[-1]]
Output: [[-1]]

Constraints:

    m == rooms.length
    n == rooms[i].length
    1 <= m, n <= 250
    rooms[i][j] is -1, 0, or 231 - 1.

"""

class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        q = deque()
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        for i in range(len(rooms)):
            for j in range(len(rooms[0])):
                if rooms[i][j] == 0: q.append((i, j))
        nearest = 0
        vis = [[False] * len(rooms[0]) for _ in range(len(rooms))]
        while q:
            length = len(q)
            nearest += 1
            for _ in range(length):
                (i, j) = q.popleft()
                for d in dirs:
                    x = i + d[0]
                    y = j + d[1]
                    if x < 0 or y < 0 or x >= len(rooms) or y >= len(rooms[0]) or rooms[x][y] == -1 or vis[x][y]: continue
                    vis[x][y] = True
                    rooms[x][y] = min(rooms[x][y], nearest)
                    q.append((x, y))
