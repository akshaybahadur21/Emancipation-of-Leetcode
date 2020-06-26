/*

129. Sum Root to Leaf Numbers
Medium

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Apprach 1
    // Store all the paths to leaf in a list of list
    // traverse the list<list> and return
    List<List<Integer>> resList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, new ArrayList<>());
        int res = 0;
        for (List<Integer> l : resList){
            int temp = 0;
            for(int i : l){
                temp = temp*10 + i;
            }
            res += temp;
        }
        return res;
    }
    
    private void dfs(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null){
            resList.add(new ArrayList<Integer>(list));
        }
        else{
            dfs(node.left, list);
            dfs(node.right, list);
        }
        list.remove(list.size() - 1);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Apprach 2
    // Keep a local integer value which stores the value of all the nodes in that path
    // keep a global integer which we will update on finding a leaf.
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int temp){
        if (node == null) return;
        temp = temp*10 + node.val;
        if (node.left == null && node.right == null){
            res += temp;
        }
        else{
            dfs(node.left, temp);
            dfs(node.right, temp);
        }
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        dfs(root, new StringBuilder(), sum);
        return sum[0];
    }
    private void dfs(TreeNode node, StringBuilder sb, int[] sum){
        if(node == null) return;
        if(node.left == null && node.right == null){
            sb.append(node.val);
            sum[0] += Integer.valueOf(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(node.val);
        dfs(node.left, sb, sum);
        dfs(node.right, sb, sum);
        sb.deleteCharAt(sb.length() - 1);
    }
}
