/*

364. Nested List Weight Sum II

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.

Return the sum of each integer in nestedList multiplied by its weight.

Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
1*3 + 4*2 + 6*1 = 17
 

Constraints:

1 <= nestedList.length <= 50
The values of the integers in the nested list is in the range [-100, 100].
The maximum depth of any integer is less than or equal to 50.

*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int max = 0, count = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // create a map for depth
        Map<String, Integer> map = new HashMap<>();
        dfs(nestedList, map, 1);
        int[] res = new int[]{0};
        count = 0;
        calc(nestedList, map, res);
        return res[0];
    }
    
    private void calc(List<NestedInteger> nestedList, Map<String, Integer> map, int[] res){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                String s = String.valueOf(n.getInteger()) + String.valueOf(count);
                int val = n.getInteger() * (max - map.get(s) + 1);
                res[0] += val;
                count++;
            }
            else{
                calc(n.getList(), map, res);
            }
        }
    }
    
    private void dfs(List<NestedInteger> nestedList, Map<String, Integer> map, int depth){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                String s = String.valueOf(n.getInteger()) + String.valueOf(count);
                map.put(s, depth);
                count++;
                max = Math.max(max, depth);
            }
            else{
                dfs(n.getList(), map, depth + 1);
            }
        }
    }
}
