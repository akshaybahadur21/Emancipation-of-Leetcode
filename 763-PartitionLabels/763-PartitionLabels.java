/*

763. Partition Labels
Medium

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.

*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        // 2 passes
        // record the last position of an element in the first pass.
        // in the second pass, fill the list and return
        List<Integer> resList = new ArrayList<>();
        if(!validateInput(S)) return resList;
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;
        int count = 0;
        int last = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            count++;
            if(last == i){
                resList.add(count);
                count = 0;
            }
        }
        return resList;
    }
    private boolean validateInput(String S){
        if(S == null || S.length() == 0)
            return false;
        return true;
    }
}
