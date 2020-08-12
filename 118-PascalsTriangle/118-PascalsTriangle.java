/*

118. Pascal's Triangle
Easy

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (numRows <= 0) return resList;
        for (int i = 0; i < numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++){
                if (j==0 || j==i) row.add(1);
                else row.add(resList.get(i-1).get(j-1) + resList.get(i-1).get(j));
            }
            resList.add(row);
        }
        return resList;
    }
}
