/*

670. Maximum Swap
Medium

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: 9973
Output: 9973
Explanation: No swap.

Note:

    The given number is in the range [0, 108]

*/

class Solution {
    public int maximumSwap(int num) {
        char[] cArr = String.valueOf(num).toCharArray();
        int max = 0, idx = -1;
        for(int i = 0; i < cArr.length - 1; i++){
            for(int j = cArr.length - 1; j > i; j--){
                if(Character.getNumericValue(cArr[j]) > max){
                    max = Math.max(max, Character.getNumericValue(cArr[j]));
                    idx = j;
                }
            }
            if(max > Character.getNumericValue(cArr[i])){
                swap(cArr, i, idx);
                return Integer.valueOf(String.valueOf(cArr));
            }
            max = 0;
        }
        return num;
    }
    private void swap(char[] cArr, int i, int j){
        char temp = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = temp;
    }
}
