/*

997. Find the Town Judge
Easy

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 
Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

 

Note:

    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N

Link : https://leetcode.com/problems/find-the-town-judge/

*/

// Used a graph-based approach and maintained a hashmap for all trust relationships

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (trust.length==0)
            return 1;
        
        Map<Integer,Set<Integer>> lookupMap = new HashMap<>();
        Set<Integer> trustKeySet = new HashSet<>();
        
        for(int i=0;i<trust.length;i++){
            trustKeySet.add(trust[i][0]);
            if (!lookupMap.containsKey(trust[i][1])){
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(trust[i][0]);
                lookupMap.put(trust[i][1],tempSet);
            }
            else{
                lookupMap.get(trust[i][1]).add(trust[i][0]);
            }
        }
        
        
        for (Map.Entry<Integer,Set<Integer>> entry : lookupMap.entrySet()){
            if (entry.getValue().size() == N-1 && !trustKeySet.contains(entry.getKey()))
                return entry.getKey();
        }
        
        return -1;
    }
}
