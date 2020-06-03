/*

1029. Two City Scheduling
Easy

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

Note:

    1 <= costs.length <= 100
    It is guaranteed that costs.length is even.
    1 <= costs[i][0], costs[i][1] <= 1000

*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        Arrays.sort(costs, (c1, c2) -> (c1[1] - c1[0]) - (c2[1] - c2[0]));
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][1] + costs[costs.length-i-1][0];
        }
        return res;
    }
}
