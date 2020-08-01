/*

Problem Statement #
Given a sequence, find the length of its Longest Palindromic Subsequence (LPS). In a palindromic subsequence, elements read the same backward and forward.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: "abdbca"
Output: 5
Explanation: LPS is "abdba".
Example 2:

Input: = "cddpd"
Output: 3
Explanation: LPS is "ddd".
Example 3:

Input: = "pqr"
Output: 1
Explanation: LPS could be "p", "q" or "r".
Basic Solution #
A basic brute-force solution could be to try all the subsequences of the given sequence. We can start processing from the beginning and the end of the sequence. So at any step, we have two options:

If the element at the beginning and the end are the same, we increment our count by two and make a recursive call for the remaining sequence.
We will skip the element either from the beginning or the end to make two recursive calls for the remaining subsequence.
If option one applies then it will give us the length of LPS; otherwise, the length of LPS will be the maximum number returned by the two recurse calls from the second option.

*/

class LPS {

  public int findLPSLength(String st) {
    return findLPSLengthRecursive(st, 0, st.length()-1);
  }

  private int findLPSLengthRecursive(String st, int lo, int hi) {
    if(lo > hi) return 0;
    if(lo == hi) return 1;
    if(st.charAt(lo) == st.charAt(hi)) return 2 + findLPSLengthRecursive(st, lo + 1, hi - 1);
    int c1 = findLPSLengthRecursive(st, lo, hi - 1);
    int c2 = findLPSLengthRecursive(st, lo + 1, hi);
    return Math.max(c1, c2);
  }

  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}

class LPS {

  public int findLPSLength(String st) {
    Integer[][] dp = new Integer[st.length()][st.length()];
    return findLPSLengthRecursive(dp, st, 0, st.length()-1);
  }

  private int findLPSLengthRecursive(Integer[][] cache, String st, int lo, int hi) {
    if(lo > hi) return 0;
    if(lo == hi) return 1;
    if(cache[lo][hi] != null) return cache[lo][hi];
    if(st.charAt(lo) == st.charAt(hi)) return 2 + findLPSLengthRecursive(cache, st, lo + 1, hi - 1);
    int c1 = findLPSLengthRecursive(cache, st, lo + 1, hi);
    int c2 = findLPSLengthRecursive(cache, st, lo, hi - 1);
    cache[lo][hi] = Math.max(c1, c2);
    return cache[lo][hi];
  }

  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}

/*

Since our memoization array dp[st.length()][st.length()] stores the results for all the subproblems, we can conclude that we will not have more than  N ∗ N N∗N subproblems (where ‘N’ is the length of the input sequence). This means that our time complexity will be  O ( N 2 ) O(N ​2 ​​ ).

Bottom-up Dynamic Programming #
Since we want to try all the subsequences of the given sequence, we can use a two-dimensional array to store our results. We can start from the beginning of the sequence and keep adding one element at a time. At every step, we will try all of its subsequences. So for every startIndex and endIndex in the given string, we will choose one of the following two options:

If the element at the startIndex matches the element at the endIndex, the length of LPS would be two plus the length of LPS till startIndex+1 and endIndex-1.
If the element at the startIndex does not match the element at the endIndex, we will take the maximum LPS created by either skipping element at the startIndex or the endIndex.
So our recursive formula would be:

  if st[endIndex] == st[startIndex] 
    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1]
  else 
    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1])
*/

class LPS {

  public int findLPSLength(String st) {
    int[][] dp = new int[st.length()][st.length()];
    for(int i = 0; i < st.length(); i++)
      dp[i][i] = 1;
    for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
      for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
        if (st.charAt(startIndex) == st.charAt(endIndex)) 
          dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
        else 
          dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
      }
    }
    return dp[0][st.length() - 1];
  }


  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }
}
