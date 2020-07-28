/*

Introduction #

Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit

This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
Problem Statement #

Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
Basic Solution #

A basic brute-force solution could be to try all combinations of the given items (as we did above), allowing us to choose the one with maximum profit and a weight that doesn’t exceed ‘C’. Take the example of four items (A, B, C, and D), as shown in the diagram below. To try all the combinations, our algorithm will look like:

for each item 'i' 
  create a new set which INCLUDES item 'i' if the total weight does not exceed the capacity, and 
     recursively process the remaining capacity and items
  create a new set WITHOUT item 'i', and recursively process the remaining items 
return the set from the above two sets with higher profit 

*/

class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    return this.knapsackRecursive(profits, weights, capacity, 0);
  }

  private int knapsackRecursive(int[] profits, int[] weights, int capacity, int idx) {
    if (capacity <= 0 || idx >= profits.length)
      return 0;

    int profit1 = 0;
    if( weights[idx] <= capacity )
        profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                capacity - weights[idx], idx + 1);

    int profit2 = knapsackRecursive(profits, weights, capacity, idx + 1);

    return Math.max(profit1, profit2);
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}


class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    return this.knapsackRecursive(dp, profits, weights, capacity, 0);
  }

  private int knapsackRecursive(Integer[][] cache, int[] profits, int[] weights, int capacity,
      int idx) {

    if (capacity <= 0 || idx >= profits.length)
      return 0;

    if(cache[idx][capacity] != null)
      return cache[idx][capacity];

    int profit1 = 0;
    if( weights[idx] <= capacity )
        profit1 = profits[idx] + knapsackRecursive(cache, profits, weights,
                capacity - weights[idx], currentIndex + 1);

    int profit2 = knapsackRecursive(cache, profits, weights, capacity, idx + 1);

    cache[currentIndex][capacity] = Math.max(profit1, profit2);
    return cache[currentIndex][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}

/*

Bottom-up Dynamic Programming #

Let’s try to populate our dp[][] array from the above solution, working in a bottom-up fashion. Essentially, we want to find the maximum profit for every sub-array and for every possible capacity. This means, dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.

So, for each item at index ‘i’ (0 <= i < items.length) and capacity ‘c’ (0 <= c <= capacity), we have two options:

    Exclude the item at index ‘i’. In this case, we will take whatever profit we get from the sub-array excluding this item => dp[i-1][c]
    Include the item at index ‘i’ if its weight is not more than the capacity. In this case, we include its profit plus whatever profit we get from the remaining capacity and from remaining items => profit[i] + dp[i-1][c-weight[i]]

*/

class Knapsack {

  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
      return 0;

    int n = profits.length;
    int[][] dp = new int[n][capacity + 1];

    for(int i=0; i < n; i++)
      dp[i][0] = 0;

    for(int c=0; c <= capacity; c++) {
      if(weights[0] <= c)
        dp[0][c] = profits[0];
    }

    for(int i=1; i < n; i++) {
      for(int c=1; c <= capacity; c++) {
        int profit1= 0, profit2 = 0;
        if(weights[i] <= c)
          profit1 = profits[i] + dp[i-1][c-weights[i]];
        profit2 = dp[i-1][c];
        dp[i][c] = Math.max(profit1, profit2);
      }
    }

    return dp[n-1][capacity];
  }

  public static void main(String[] args) {
    Knapsack ks = new Knapsack();
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    int maxProfit = ks.solveKnapsack(profits, weights, 7);
    System.out.println("Total knapsack profit ---> " + maxProfit);
    maxProfit = ks.solveKnapsack(profits, weights, 6);
    System.out.println("Total knapsack profit ---> " + maxProfit);
  }
}
