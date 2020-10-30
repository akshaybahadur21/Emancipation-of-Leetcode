/*

1209. Remove All Adjacent Duplicates in String II
Medium

Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:

    1 <= s.length <= 10^5
    2 <= k <= 10^4
    s only contains lower case English letters.

*/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek().getChar() != c)
                stack.push(new Pair(c, 1));
            else if(!stack.isEmpty() && stack.peek().getChar() == c){
                if(stack.peek().getPos() == k - 1){
                    for(int i = 0; i < k - 1; i++) stack.pop();
                }
                else stack.push(new Pair(c, stack.peek().getPos() + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            if(stack.peek().getPos() == k) {
                for(int i = 0; i < k ; i++) stack.pop();
            }
            sb.append(stack.pop().getChar());
        }
        return sb.reverse().toString();
    }
}
class Pair{
    char ch;
    int pos;
    Pair(char ch, int pos){
        this.ch = ch;
        this.pos = pos;
    }
    public char getChar(){
        return ch;
    }
    public int getPos(){
        return pos;
    }
}
