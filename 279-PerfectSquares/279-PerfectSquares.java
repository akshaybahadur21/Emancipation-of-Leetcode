/*

279. Perfect Squares
Medium

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*/

class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(n);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int len = q.size();
            for(int i = 0; i < len ; i++){
                int temp = q.poll();
                if(vis.contains(temp)) continue;
                vis.add(temp);
                for(int j = 1; j <= Math.sqrt(temp); j++){
                    if(temp - (j * j) == 0) return level;
                    q.add(temp - (j * j));
                }
            }
        }
        return level;
    }
}
