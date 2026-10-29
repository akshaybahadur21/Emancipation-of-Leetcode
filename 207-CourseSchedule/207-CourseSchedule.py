"""

207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.

"""

class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        def get_graph():
            indegree = {}
            graph = defaultdict(list)
            for i in range(numCourses):
                indegree[i] = 0
            for a, b in prerequisites:
                indegree[a] += 1
                graph[b].append(a)
            return indegree, graph
        
        indegree, graph = get_graph()
        q = deque([node for node, val in indegree.items() if val == 0])
        node_vis = 0
        while q:
            curr = q.popleft()
            node_vis += 1
            for neighbor in graph[curr]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)
        return node_vis == numCoursesz
