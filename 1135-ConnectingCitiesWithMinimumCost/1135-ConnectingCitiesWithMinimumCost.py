"""

1135. Connecting Cities With Minimum Cost

There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.

Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,

The cost is the sum of the connections' costs used.

Example 1:

Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.

Example 2:

Input: n = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: There is no way to connect all cities even if all edges are used.

Constraints:

    1 <= n <= 104
    1 <= connections.length <= 104
    connections[i].length == 3
    1 <= xi, yi <= n
    xi != yi
    0 <= costi <= 105

"""

class Solution:
    def minimumCost(self, n: int, connections: List[List[int]]) -> int:
        def get_graph():
            graph = defaultdict(list)
            for i, j, c in connections:
                graph[i].append([j, c])
                graph[j].append([i, c])
            return graph
        graph = get_graph()
        heap = [(0, 1)] #cost = 0 for node = 1
        res = 0
        vis = set()
        while heap:
            if len(vis) == n: return res
            c, node = heappop(heap)
            if node in vis: continue
            vis.add(node)
            res += c
            for child, cost in graph[node]:
                heappush(heap, (cost, child))
        return -1
