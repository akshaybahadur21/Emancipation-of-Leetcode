/*

293. Flip Game
Easy

You are playing a Flip Game with your friend.

You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.

Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].

Example 1:

Input: currentState = "++++"
Output: ["--++","+--+","++--"]

Example 2:

Input: currentState = "+"
Output: []

Constraints:

    1 <= currentState.length <= 500
    currentState[i] is either '+' or '-'.

*/

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> resList = new ArrayList<>();
        for(int i = 0; i < currentState.length() - 1; i++){
            String subStr = currentState.substring(i, i + 2);
            if(subStr.equals("++")){
                String pre = currentState.substring(0, i);
                String post = currentState.substring(i + 2, currentState.length());
                resList.add(new String(pre.concat("--".concat(post))));
            }
        }
        return resList;
    }
}
