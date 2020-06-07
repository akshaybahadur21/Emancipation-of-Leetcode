/*

518. Coin Change 2
Medium

You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10] 
Output: 1

Note:

You can assume that

    0 <= amount <= 5000
    1 <= coin <= 5000
    the number of coins is less than 500
    the answer is guaranteed to fit into signed 32-bit integer

*/


//Memory Limit Exceed
class Solution {
    public int change(int amount, int[] coins) {
        List<List<Integer>> resList = new ArrayList<>();
        if(coins.length == 0 && amount == 0) return 1;
        if(!validateInput(amount, coins)) return 0;
        Arrays.sort(coins);
        dfs(coins, amount, 0, 0, new ArrayList<>(), resList);
        return resList.size();
    }
    
    private void dfs(int[] coins, int amount, int curr, int idx, List<Integer> list, List<List<Integer>> resList){
        if(amount == curr){
           resList.add(new ArrayList<>(list));
            return;
        }
        if(curr > amount) return;
        for(int i = idx; i < coins.length; i++){
            list.add(coins[i]);
            curr = curr + coins[i];
            dfs(coins, amount, curr, i, list, resList);
            curr = curr - coins[i];
            list.remove(list.size() - 1);
        }
    }
    
    private boolean validateInput(int amount, int[] coins){
        if(coins == null || coins.length == 0)
            return false;
        return true;
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 && amount == 0) return 1;
        if(!validateInput(amount, coins)) return 0;
        Arrays.sort(coins);
        int[][] map = new int[amount + 1][coins.length];
        for (int[] row : map)
            Arrays.fill(row, -1);
        return dfs(coins, amount, 0, map);
    }
    
    private int dfs(int[] coins, int amount, int idx, int[][] map){
        if(amount == 0)return 1;
        if (idx == coins.length) return 0;
        if(map[amount][idx] != -1) return map[amount][idx];
        
        int cnt = 0;
        for(int i = idx; i < coins.length; i++){
            if(coins[i] > amount) break;
            int times = 1;
            while(times * coins[i] <= amount){
                cnt += dfs(coins, amount - times * coins[i], i + 1, map);
                times++;
            }
        }
        map[amount][idx] = cnt;
        return cnt;
    }
    
    private boolean validateInput(int amount, int[] coins){
        if(coins == null || coins.length == 0)
            return false;
        return true;
    }
}
