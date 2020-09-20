/*

254. Factor Combinations
Medium

Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Example 1:

Input: 1
Output: []

Example 2:

Input: 37
Output:[]

Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

*/

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> resList = new ArrayList<>();
        if(n <= 1) return resList;
        int len = n / 2, count = 0;
        int [] nums = new int [len - 1];
        for(int i = 2; i<= len; i++) nums[count++] = i;
        dfs(nums, n, resList, new ArrayList<>(), 0);
        return resList;
    }
    private void dfs(int[] nums, int n,List<List<Integer>> resList, List<Integer> list, int idx){
        if(n == 1){
            resList.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            if(n % nums[i] != 0) continue;
            list.add(nums[i]);
            dfs(nums, n / nums[i], resList, list, i);
            list.remove(list.size() - 1);
        }
    }
}
