/*

Problem Statement #
Given a string, find the length of its Longest Palindromic Substring (LPS). In a palindromic string, elements read the same backward and forward.

Example 1:

Input: "abdbca"
Output: 3
Explanation: LPS is "bdb".
Example 2:

Input: = "cddpd"
Output: 3
Explanation: LPS is "dpd".
Example 3:

Input: = "pqr"
Output: 1
Explanation: LPS could be "p", "q" or "r".
Basic Solution #
This problem follows the Longest Palindromic Subsequence pattern. The only difference is that in a palindromic subsequence characters can be non-adjacent, whereas in a substring all characters should form a palindrome. We will follow a similar approach though.

The brute-force solution will be to try all the substrings of the given string. We can start processing from the beginning and the end of the string. So at any step, we will have two options::

If the element at the beginning and the end are the same, we make a recursive call to check if the remaining substring is also a palindrome. If so, the substring is a palindrome from beginning to the end.
We will skip either the element from the beginning or the end to make two recursive calls for the remaining substring. The length of LPS would be the maximum of these two recursive calls.

The above algorithm has a time and space complexity ofO(n2)O(n​2​​ ) because we will not have more thann∗nn∗n subproblems.
*/

class LPS {

  public int findLPSLength(String st) {
    return findLPSLengthRecursive(st, 0, st.length() - 1);
  }

  private int findLPSLengthRecursive(String s, int lo, int hi) {
    if(lo > hi) return 0;
    if(lo == hi) return 1;
    if(s.charAt(lo) == s.charAt(hi)) {
      int rem = hi - lo - 1;
      if(rem == findLPSLengthRecursive(s, lo + 1, hi - 1))
        return 2 + rem;
      }
    int c1 = findLPSLengthRecursive(s, lo + 1, hi);
    int c2 = findLPSLengthRecursive(s, lo, hi - 1);
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
    return findLPSLengthRecursive(dp, st, 0, st.length() - 1);
  }

  private int findLPSLengthRecursive(Integer[][] cache, String s, int lo, int hi) {
    if(lo > hi) return 0;
    if(lo == hi) return 1;
    if(cache[lo][hi] != null) return cache[lo][hi];
    if(s.charAt(lo) == s.charAt(hi)){
      int rem = hi - lo - 1;
      if(rem == findLPSLengthRecursive(cache, s, lo + 1, hi - 1))
        return 2 + rem;
    }
    int c1 = findLPSLengthRecursive(cache, s, lo + 1, hi);
    int c2 = findLPSLengthRecursive(cache, s, lo, hi - 1);
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
