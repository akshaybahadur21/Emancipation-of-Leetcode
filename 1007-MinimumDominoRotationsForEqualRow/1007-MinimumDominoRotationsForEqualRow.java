/*

1007. Minimum Domino Rotations For Equal Row
Medium

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

Example 1:

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

Constraints:

    2 <= A.length == B.length <= 2 * 104
    1 <= A[i], B[i] <= 6

*/

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, List<Integer>> mapA = new HashMap<>();
        Map<Integer, List<Integer>> mapB = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(!mapA.containsKey(A[i])) mapA.put(A[i], new ArrayList<>());
            mapA.get(A[i]).add(i + 1);
        }
        for(int i = 0; i < B.length; i++){
            if(!mapB.containsKey(B[i])) mapB.put(B[i], new ArrayList<>());
            mapB.get(B[i]).add(i + 1);
        }
        for(Map.Entry<Integer, List<Integer>> entry : mapA.entrySet()){
            int key = entry.getKey();
            if(!mapB.containsKey(key)) continue;
            if(mapA.get(key).size() + mapB.get(key).size() >= A.length){
                Set<Integer> set = new HashSet<>();
                set.addAll(mapA.get(key));
                set.addAll(mapB.get(key));
                if(set.size() == A.length) return Math.min(mapA.get(key).size(), Math.min(A.length - mapA.get(key).size(), A.length - mapB.get(key).size()));
            }
        }
        return -1;
    }
}
