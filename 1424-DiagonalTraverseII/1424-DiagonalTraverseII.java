/*

1424. Diagonal Traverse II
Medium
Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

Example 1:

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]

Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i].length <= 10^5
    1 <= nums[i][j] <= 10^9
    There at most 10^5 elements in nums.

*/

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> resList = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        int MAX = 0;
        for(int i = 0; i < nums.size(); i++)
            MAX = Math.max(MAX, nums.get(i).size()); 
        
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{0, 0});
        visited.add(hash(0, 0, MAX));
        int[][] dirs = new int[][]{{1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int temp[] = q.poll();
                resList.add(nums.get(temp[0]).get(temp[1]));
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(!visited.contains(hash(x, y, MAX)) && x < nums.size() && y < nums.get(x).size() && nums.get(x) != null && nums.get(x).get(y) != null){
                        q.add(new int[]{x, y});
                        visited.add(hash(x, y, MAX));
                    }
                }
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
    private int hash(int row, int col, final int NC){
        return row * NC + col;
    }
}
