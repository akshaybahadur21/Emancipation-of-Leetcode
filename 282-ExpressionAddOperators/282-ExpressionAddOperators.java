/*

282. Expression Add Operators
Hard

Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]

Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]

Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:

Input: num = "00", target = 0
Output: ["0*0","0+0","0-0"]

Example 5:

Input: num = "3456237490", target = 9191
Output: []

Constraints:

    1 <= num.length <= 10
    num consists of only digits.
    -231 <= target <= 231 - 1

*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        dfs(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void dfs(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                dfs(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                dfs(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                dfs(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                dfs(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
