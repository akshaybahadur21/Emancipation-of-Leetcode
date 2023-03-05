/*

1345. Jump Game IV
Hard

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.

Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

Constraints:

    1 <= arr.length <= 5 * 104
    -108 <= arr[i] <= 108

*/

class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i< arr.length; i++) map.computeIfAbsent(arr[i],v -> new ArrayList<>()).add(i);
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[arr.length];
        q.add(0);
        int res = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int curr = q.poll();
                if(curr == arr.length - 1) return res;
                if(curr < 0 || curr >= arr.length || vis[curr]) continue;
                vis[curr] = true;
                q.add(curr + 1);
                q.add(curr - 1);
                if(map.containsKey(arr[curr])){
                    List<Integer> list = map.get(arr[curr]);
                    for(int n : list) {
                     q.add(n);
                    }

                }
            }
            res++;
        }
        return -1;
    }
}
