/*

1079. Letter Tile Possibilities
Medium

You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.

Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:

Input: "AAABBC"
Output: 188

Note:

    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.

*/

class Solution {
    public int numTilePossibilities(String tiles) {
        //Recursive backtracking
        Set<String> set = new HashSet<>();
        boolean vis[] = new boolean[tiles.length()];
        dfs(tiles, set, "", vis);
        return set.size();
    }
    private void dfs(String tiles, Set<String> set, String curr, boolean vis[]){
        if(curr.length() > 0 && curr.length() <= tiles.length())
            set.add(curr);
        if(curr.length() > tiles.length()) 
            return;
        for(int i = 0; i < tiles.length(); i++){
            if(vis[i]) continue;
            vis[i] = true;
            dfs(tiles, set, curr + tiles.charAt(i), vis);
            vis[i] = false;
        }
    }
}
