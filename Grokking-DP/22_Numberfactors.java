/*

Problem Statement #
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

Example 1:

n : 4
Number of ways = 4
Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4} 
Example 2:

n : 5
Number of ways = 6
Explanation: Following are the six ways we can express 'n' : {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1}, 
{1,4}, {4,1}

*/

class ExpressNumber {
  public int CountWays(int n) {
    if(n == 0) return 1;
    if(n == 1) return 1;
    if(n == 2) return 1;
    if(n == 3) return 2;
    return CountWays(n -1) + CountWays(n - 3) + CountWays(n - 4);
  }
  public static void main(String[] args) {
    ExpressNumber en = new ExpressNumber();
    System.out.println(en.CountWays(4));
    System.out.println(en.CountWays(5));
    System.out.println(en.CountWays(6));
  }
}

class ExpressNumber {
  public int CountWays(int n) {
    Integer cache[] = new Integer[n + 1];
    return CountWaysRecursive(cache, n);
  }
  public int CountWaysRecursive(Integer[] cache, int n) {
    if(n == 0) return 1;
    if(n == 1) return 1;
    if(n == 2) return 1;
    if(n == 3) return 2;
    if(cache[n] != null) return cache[n];
    cache[n] = CountWaysRecursive(cache, n - 1) + CountWaysRecursive(cache, n - 3) + CountWaysRecursive(cache, n - 4);
    return cache[n];
  }
  public static void main(String[] args) {
    ExpressNumber en = new ExpressNumber();
    System.out.println(en.CountWays(4));
    System.out.println(en.CountWays(5));
    System.out.println(en.CountWays(6));
  }
}

class ExpressNumber {
  public int CountWays(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    for(int i = 4; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
    return dp[n];
  }
  public static void main(String[] args) {
    ExpressNumber en = new ExpressNumber();
    System.out.println(en.CountWays(4));
    System.out.println(en.CountWays(5));
    System.out.println(en.CountWays(6));
  }
}
