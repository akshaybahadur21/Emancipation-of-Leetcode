/*

1291. Sequential Digits
Medium

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Constraints:

    10 <= low <= high <= 10^9

*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> resList = new ArrayList<>();
        if(!validateInput(low, high)) return resList;
        dfs(low, high,new StringBuilder(), 1, resList);
        Collections.sort(resList, (l1, l2) -> String.valueOf(l1).length() != String.valueOf(l2).length() ? String.valueOf(l1).length() - String.valueOf(l2).length() : l1 - l2);
        return resList;
    }
    private void dfs(int low, int high, StringBuilder sb ,int idx, List<Integer>resList){
        int curr = sb.length() == 0 ? 0 :Integer.valueOf(sb.toString());
        if(curr > high) return;
        if(curr >= low && curr <= high){
            boolean canAdd = true;
            for(int i = 0; i < sb.length() - 1; i++){
                if(Character.getNumericValue(sb.charAt(i + 1)) - Character.getNumericValue(sb.charAt(i)) != 1) {
                    canAdd = false;
                    break;
                }
            }
            if(canAdd) resList.add(curr);
        }
        for(int i = idx ; i <= 9; i++){
            sb.append(i);
            dfs(low, high, sb, i + 1 , resList);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private boolean validateInput(int low, int high){
        if(low >= high) return false;
        return true;
    }
}


class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> resList = new ArrayList<>();
        for(int i = 1; i <= 9 - String.valueOf(low).length() + 1; i++)
            dfs(i, low, high, resList, 0);
        Collections.sort(resList);
        return resList;
    }
    private void dfs(int start, int low, int high, List<Integer>resList, int curr){
        if(curr >= low && curr <= high){
        char[] arr = String.valueOf(curr).toCharArray();
        for(int i = 1; i < arr.length; i++){
            if(Character.getNumericValue(arr[i]) - Character.getNumericValue(arr[i-1]) != 1) return;
        }
            resList.add(curr);
        }
        if(curr > high) return;

        dfs(start + 1, low, high, resList, curr * 10 + start);
    }
    
}
