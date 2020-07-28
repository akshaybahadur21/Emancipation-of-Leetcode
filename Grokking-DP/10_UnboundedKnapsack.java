/*

Introduction #

Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an unlimited quantity of an item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.

5 Apples (total weight 5) => 75 profit
1 Apple + 2 Oranges (total weight 5) => 55 profit
2 Apples + 1 Melon (total weight 5) => 80 profit
1 Orange + 1 Melon (total weight 5) => 70 profit

This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
Problem Statement #

Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
Basic Solution #

A basic brute-force solution could be to try all combinations of the given items to choose the one with maximum profit and a weight that doesn’t exceed ‘C’. This is what our algorithm will look like:

for each item 'i' 
  create a new set which includes one quantity of item 'i' if it does not exceed the capacity, and 
     recursively call to process all items 
  create a new set without item 'i', and recursively process the remaining items 
return the set from the above two sets with higher profit 

*/

class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return this.knapsackRecursive(profits, weights, capacity, 0);
  }

  private int knapsackRecursive(int[] profits, int[] weights, int capacity, int idx) {
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || 
        idx >= profits.length)
      return 0;

    int profit1 = 0;
    if (weights[idx] <= capacity)
      profit1 = profits[idx]
          + knapsackRecursive(profits, weights, capacity - weights[idx], currentIndex);

    int profit2 = knapsackRecursive(profits, weights, capacity, idx + 1);

    return Math.max(profit1, profit2);
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = { 15, 50, 60, 90 };
    int[] weights = { 1, 3, 4, 5 };
    int maxProfit = ks.solveKnapsack(profits, weights, 8);
    System.out.println(maxProfit);
  }
}

class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    return this.knapsackRecursive(dp, profits, weights, capacity, 0);
  }

  private int knapsackRecursive(Integer[][] cache, int[] profits, int[] weights, int capacity,
      int idx) {

    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
        idx >= profits.length)
      return 0;

    if(cache[idx][capacity] == null) {
      int profit1 = 0;
      if( weights[idx] <= capacity )
          profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                  capacity - weights[idx], idx);

      int profit2 = knapsackRecursive(dp, profits, weights, capacity, idx + 1);

      cache[idx][capacity] = Math.max(profit1, profit2);
    }

    return cache[idx][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {15, 50, 60, 90};
    int[] weights = {1, 3, 4, 5};
    System.out.println(ks.solveKnapsack(profits, weights, 8));
    System.out.println(ks.solveKnapsack(profits, weights, 6));
  }
}

/*

Bottom-up Dynamic Programming #

Let’s try to populate our dp[][] array from the above solution, working in a bottom-up fashion. Essentially, what we want to achieve is: “Find the maximum profit for every sub-array and for every possible capacity”.

So for every possible capacity ‘c’ (0 <= c <= capacity), we have two options:

    Exclude the item. In this case, we will take whatever profit we get from the sub-array excluding this item: dp[index-1][c]
    Include the item if its weight is not more than the ‘c’. In this case, we include its profit plus whatever profit we get from the remaining capacity: profit[index] + dp[index][c-weight[index]]

Finally, we have to take the maximum of the above two values:

    dp[index][c] = max (dp[index-1][c], profit[index] + dp[index][c-weight[index]]) 

*/

class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
      return 0;

    int n = profits.length;
    int[][] dp = new int[n][capacity + 1];

    for(int i=0; i < n; i++)
      dp[i][0] = 0;

    for(int i=0; i < n; i++) {
      for(int c=1; c <= capacity; c++) {
        int profit1=0, profit2=0;
        if(weights[i] <= c)
          profit1 = profits[i] + dp[i][c-weights[i]];
        if( i > 0 )
          profit2 = dp[i-1][c];
        dp[i][c] = profit1 > profit2 ? profit1 : profit2;
      }
    }

    return dp[n-1][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {15, 50, 60, 90};
    int[] weights = {1, 3, 4, 5};
    System.out.println(ks.solveKnapsack(profits, weights, 8));
    System.out.println(ks.solveKnapsack(profits, weights, 6));
  }
}
