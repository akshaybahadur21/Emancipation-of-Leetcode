/*

32. Longest Valid Parentheses
Hard

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

*/

class Solution {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = s.charAt(i) == '(' ? 1 : -1;
        return dfs(arr, 0, arr.length - 1);
    }
    private int dfs(int[] arr, int lo, int hi){
        while(lo <= hi && arr[lo] == -1) lo++;
        while(hi >= lo && arr[hi] == 1) hi--;
        if(lo >= hi) return 0;
        for(int i = lo, count = 0; i <= hi; i++){
            count += arr[i];
            if(count == -1)
                return Math.max(i - lo, dfs(arr, i , hi));
        }
        for(int i = hi, count = 0; i >= lo; i--){
            count += arr[i];
            if(count == 1)
                return Math.max(hi - i, dfs(arr, lo, i));
        }
        return hi - lo + 1;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = s.charAt(i) == '(' ? 1 : -1;
        Integer[][] cache = new Integer[s.length()][s.length()];
        return dfs(cache, arr, 0, arr.length - 1);
    }
    private int dfs(Integer[][] cache, int[] arr, int lo, int hi){
        while(lo <= hi && arr[lo] == -1) lo++;
        while(hi >= lo && arr[hi] == 1) hi--;
        if(lo >= hi) return 0;
        if(cache[lo][hi] != null) return cache[lo][hi];
        for(int i = lo, count = 0; i <= hi; i++){
            count += arr[i];
            if(count == -1){
                cache[lo][hi] = Math.max(i - lo, dfs(cache, arr, i , hi));
                return cache[lo][hi];
            }
        }
        for(int i = hi, count = 0; i >= lo; i--){
            count += arr[i];
            if(count == 1){
                cache[lo][hi] = Math.max(hi - i, dfs(cache, arr, lo, i));
                return cache[lo][hi];
            }
        }
        cache[lo][hi] = hi - lo + 1;
        return cache[lo][hi];
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        int[] res = new int[]{0};
        for(int i = 0 ;i < s.length() ; i++){
            dfs(s, i, 0, 0, res);
            max = Math.max(res[0], max);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    public void dfs(String s, int i, int openCount, int closeCount, int[]res){
        if(openCount == closeCount){
            res[0] = Math.max(res[0], openCount + closeCount);
        }
        if (i == s.length()) return;
        
        if(s.charAt(i) == '('){
            dfs(s, i+1, ++openCount, closeCount, res);
        }else if (openCount > closeCount) {
            dfs(s, i+1, openCount, ++closeCount, res);
        }
    }
}
