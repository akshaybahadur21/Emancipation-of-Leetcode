/*

56. Merge Intervals
Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (n1,n2) -> n1[0] - n2[0]);
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) return list.toArray(new int[list.size()][]);
        list.add(intervals[0]);
        for (int i = 1; i<intervals.length; i++){
            int[] listVal = list.get(list.size() -1);
            if (listVal[1] >= intervals[i][0]){
                list.remove(list.size() - 1);
                list.add(new int[]{listVal[0], Math.max(intervals[i][1], listVal[1])});
            }
            else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
