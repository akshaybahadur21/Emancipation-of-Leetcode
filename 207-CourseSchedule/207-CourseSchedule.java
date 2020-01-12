/*

207. Course Schedule
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Note:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological bfs sort
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int[] pair : prerequisites)
            indegree[pair[1]]++;
        for(int i =0; i< indegree.length; i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            numCourses--;
            int temp = q.poll();
            for(int[] pair : prerequisites){
                if (pair[0] == temp){
                    indegree[pair[1]]--;
                    if (indegree[pair[1]] == 0)
                        q.add(pair[1]);
                }
            }
        }
        return numCourses == 0;
        
    }
}
