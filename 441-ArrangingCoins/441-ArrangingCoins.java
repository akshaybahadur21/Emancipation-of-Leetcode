/*

441. Arranging Coins
Easy

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

*/

class Solution {
    public int arrangeCoins(int n) {
        if(!validateInput(n)) return 0;
        int[] res = new int[]{0};
        dfs(n, 1, res);
        return res[0];
    }
    
    private void dfs(int n, int level, int[] res){
        if(level == n){
            res[0] = level;
            return;
        }
        if(level > n){
            res[0] = level - 1;
            return;
        }
        dfs(n - level, level + 1, res);
    }
    
    private boolean validateInput(int n){
        if (n <= 0) return false;
        return true;
    }
}
