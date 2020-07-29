/*

Introduction #
We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. Now we need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths. Write a method that will return the count of pieces.

Example 1:

n: 5
Ribbon Lengths: {2,3,5}
Output: 2
Explanation: Ribbon pieces will be {2,3}.
Example 2:

n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.
Example 3:

n: 13
Ribbon Lengths: {3,5,7}
Output: 3
Explanation: Ribbon pieces will be {3,3,7}.
Problem Statement #
Given a number array to represent possible ribbon lengths and a total ribbon length ‘n’, we need to find the maximum number of pieces that the ribbon can be cut into.

This problem follows the Unbounded Knapsack pattern and is quite similar to Minimum Coin Change (MCC). The only difference is that in MCC we were asked to find the minimum number of coin changes, whereas in this problem we need to find the maximum number of pieces.

Basic Solution #
A basic brute-force solution could be to try all combinations of the given lengths to select the maximum one that gives the total length of ‘n’. This is what our algorithm will look like:

  for each length 'l' 
    create a new set which includes one quantity of length 'l' if it does not exceed 'n', and 
       recursively call to process all lengths 
    create a new set without length 'l', and recursively call to process the remaining lengths
  return the number of pieces from the above two sets with a higher number of pieces
  
*/

class CutRibbon {

  public int countRibbonPieces(int[] ribbonLengths, int total) {
    int maxPieces = this.countRibbonPiecesRecursive(ribbonLengths, total, 0);
    return maxPieces == Integer.MIN_VALUE ? -1 : maxPieces;
  }

  private int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int idx) {
    if(total == 0) return 0;
    if(idx >= ribbonLengths.length || total < 0 || ribbonLengths.length == 0) return Integer.MIN_VALUE;
    int c1 = Integer.MIN_VALUE;
    if(total >= ribbonLengths[idx]){
      int res = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[idx], idx);
      c1 = res == Integer.MIN_VALUE ? Integer.MIN_VALUE : res + 1;
    }
    int c2 = countRibbonPiecesRecursive(ribbonLengths, total, idx + 1);
    return Math.max(c1, c2);
  }

  public static void main(String[] args) {
    CutRibbon cr = new CutRibbon();
    int[] ribbonLengths = {2,3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[]{2,3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[]{3,5,7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[]{3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}

class CutRibbon {

  public int countRibbonPieces(int[] ribbonLengths, int total) {
    Integer[][] cache = new Integer[ribbonLengths.length][total + 1];
    int maxPieces = this.countRibbonPiecesRecursive(ribbonLengths, total, 0, cache);
    return maxPieces == Integer.MIN_VALUE ? -1 : maxPieces;
  }

  private int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int idx, Integer[][] cache) {
    if(total == 0) return 0;
    if(total < 0 || ribbonLengths.length == 0 || idx >= ribbonLengths.length) return Integer.MIN_VALUE;
    if(cache[idx][total] != null) return cache[idx][total];
    if(cache[idx][total] == null){
      int c1 = Integer.MIN_VALUE;
      if(total >= ribbonLengths[idx]){
        int res = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[idx], idx, cache);
        c1 = res == Integer.MIN_VALUE ? Integer.MIN_VALUE : res + 1;
      }
      int c2 = countRibbonPiecesRecursive(ribbonLengths, total, idx + 1, cache);
      cache[idx][total] = Math.max(c1, c2);
    }
    return cache[idx][total];
  }

  public static void main(String[] args) {
    CutRibbon cr = new CutRibbon();
    int[] ribbonLengths = {2,3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[]{2,3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[]{3,5,7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[]{3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}

/*

Bottom-up Dynamic Programming #
Let’s try to populate our array dp[ribbonLength][total+1] for every possible ribbon length with a maximum number of pieces.

So for every possible length ‘len’ (0<= len <= total) and for every possible ribbon length index (0 <= index < ribbonLengths.length), we have two options:

Exclude the ribbon length: In this case, we will take the maximum pieces count from the previous set => dp[index-1][len]
Include the ribbon length if its value is not more than ‘len’: In this case, we will take the maximum pieces needed to get the remaining total, plus include ‘1’ for the current ribbon length => 1 + dp[index][len-ribbonLengths[index]]

Finally, we will take the maximum of the above two values for our solution:

    dp[index][t] = max(dp[index-1][len], 1 + dp[index][len-ribbonLengths[index]])

*/

import java.util.Arrays;
class CutRibbon {
  public int countRibbonPieces(int[] ribbonLengths, int total)
  {
    int[][] dp = new int[ribbonLengths.length][total + 1];
    for(int i = 0; i < ribbonLengths.length; i++)
      for(int t = 0; t <= total; t++)
        dp[i][t] = Integer.MIN_VALUE;
    for(int i = 0; i < ribbonLengths.length; i++)
      dp[i][0] = 0;
    for(int i = 0; i < ribbonLengths.length; i++){
      for(int t = 1; t <= total; t++){
        if(i > 0)
          dp[i][t] = dp[i - 1][t];
        if(t >= ribbonLengths[i] && dp[i][t - ribbonLengths[i]] != Integer.MIN_VALUE)
          dp[i][t] = Math.max(dp[i][t], dp[i][t - ribbonLengths[i]] + 1);
      }
    }
    return dp[ribbonLengths.length - 1][total] == Integer.MIN_VALUE ? -1 : dp[ribbonLengths.length - 1][total];
  }
  public static void main(String[] args) {
    CutRibbon cr = new CutRibbon();
    int[] ribbonLengths = {2,3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[]{2,3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[]{5,3,7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[]{3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}
