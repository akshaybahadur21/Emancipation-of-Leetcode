/*

1229. Meeting Scheduler
Medium

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]

Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []

Constraints:

    1 <= slots1.length, slots2.length <= 104
    slots1[i].length, slots2[i].length == 2
    slots1[i][0] < slots1[i][1]
    slots2[i][0] < slots2[i][1]
    0 <= slots1[i][j], slots2[i][j] <= 109
    1 <= duration <= 106

*/

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //simple iterative algo
        // sort both the arrays by start date
        // find the time
        List<Integer> resList = new ArrayList<>();
        Arrays.sort(slots1, (n1, n2) -> n1[0] - n2[0]);
        Arrays.sort(slots2, (n1, n2) -> n1[0] - n2[0]);
        for(int i = 0, j = 0; i < slots1.length && j < slots2.length;){
            int[] s1 = slots1[i];
            int[] s2 = slots2[j];
            int right = Math.min(s1[1], s2[1]);
            int left = Math.max(s1[0], s2[0]);
            if(right - left >= duration){
                resList.add(left);
                resList.add(left + duration);
                return resList;
            }
            if(s1[1] > s2[1]) j++;
            else i++;
        }
        return resList;
    }
}
