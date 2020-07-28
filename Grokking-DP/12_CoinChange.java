/*

Introduction #

Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total number of distinct ways to make up that amount.

Example:

Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1} 
  2. {1,1,1,2} 
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}

Problem Statement #

Given a number array to represent different coin denominations and a total amount ‘T’, we need to find all the different ways to make a change for ‘T’ with the given coin denominations. We can assume an infinite supply of coins, therefore, each coin can be chosen multiple times.

This problem follows the Unbounded Knapsack pattern.
Basic Solution #

A basic brute-force solution could be to try all combinations of the given coins to select the ones that give a total sum of ‘T’. This is what our algorithm will look like:
    for each coin 'c' 
      create a new set which includes one quantity of coin 'c' if it does not exceed 'T', and 
         recursively call to process all coins 
      create a new set without coin 'c', and recursively call to process the remaining coins 
    return the count of sets who have a sum equal to 'T'

This problem is quite similar to Count of Subset Sum. The only difference here is that after including the item (i.e. coin), we recursively call to process all the items (including the current coin). In ‘Count of Subset Sum’, however, we were recursively calling to process only the remaining items.

*/

class CoinChange {

  public int countChange(int[] denominations, int total) {
    return this.countChangeRecursive(denominations, total, 0);
  }
  private int countChangeRecursive(int[] denominations, int total, int idx) {
    if(total == 0) return 1;
    if(idx >= denominations.length || denominations[idx] > total || total < 0) return 0;
    int sum1 = 0;
    if(total >= denominations[idx])
      sum1 = countChangeRecursive(denominations, total - denominations[idx], idx);
    int sum2 = countChangeRecursive(denominations, total, idx + 1);
    return sum1 + sum2;
  }
  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }
}

