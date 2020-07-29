/*

Problem Statement #
Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.

Example 1:

Number of stairs (n) : 3
Number of ways = 4
Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3} 
Example 2:

Number of stairs (n) : 4
Number of ways = 7
Explanation: Following are the seven ways we can climb : {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, 
{2,2}, {1,3}, {3,1}
Let’s first start with a recursive brute-force solution.

*/

class Staircase {
  public int CountWays(int n) {
    if(n == 0) return 1;
    if(n == 1) return 1;
    if(n == 2) return 2;
    return CountWays(n - 1) + CountWays(n - 2) + CountWays(n - 3);
  }
  public static void main(String[] args) {
    Staircase sc = new Staircase();
    System.out.println(sc.CountWays(3));
    System.out.println(sc.CountWays(4));
    System.out.println(sc.CountWays(5));
  }
}
class Staircase {

  public int CountWays(int n) {
    Integer cache[] = new Integer[n+1];
    return CountWaysRecursive(cache, n);
  }
  public int CountWaysRecursive(Integer cache[], int n) {
   if(n == 0) return 1;
   if(n == 1) return 1;
   if(n == 2) return 2;
   if(cache[n] != null) return cache[n];
   cache[n] = CountWaysRecursive(cache, n - 1) + CountWaysRecursive(cache, n - 2) + CountWaysRecursive(cache, n - 3);
   return cache[n];
  }
  public static void main(String[] args) {
    Staircase sc = new Staircase();
    System.out.println(sc.CountWays(3));
    System.out.println(sc.CountWays(4));
    System.out.println(sc.CountWays(5));
    System.out.println(sc.CountWays(128));
  }
}

class Staircase {
  public int CountWays(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    return dp[n];
  }
  public static void main(String[] args) {
    Staircase sc = new Staircase();
    System.out.println(sc.CountWays(3));
    System.out.println(sc.CountWays(4));
    System.out.println(sc.CountWays(5));
    System.out.println(sc.CountWays(128));
  }
}
