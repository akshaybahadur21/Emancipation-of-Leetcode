/*

119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (rowIndex <= 0) Arrays.asList(new int[]{1});
        for (int i = 0; i <= rowIndex; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++){
                if (j==0 || j==i) row.add(1);
                else row.add(resList.get(i-1).get(j-1) + resList.get(i-1).get(j));
            }
            resList.add(row);
        }
        return resList.get(rowIndex);
    }       
}
