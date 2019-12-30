/*

5296. All Elements in Two Binary Search Trees
Medium
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.


Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

 

Constraints:

    Each tree has at most 5000 nodes.
    Each node's value is between [-10^5, 10^5].

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
    //Using min Heap
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> resList = new ArrayList<>();
        if (root1 == null && root2 == null)
            return resList;
        Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2)-> n1-n2);
        dfs(root1, heap);
        dfs(root2, heap);
        while(!heap.isEmpty())
            resList.add(heap.poll());
        return resList;
        
    }
    private void dfs(TreeNode root, Queue heap){
        if (root == null)
            return;
        dfs(root.left, heap);
        heap.add(root.val);
        dfs(root.right, heap);
    }
}

//dfs
class Solution {
    //Using DFS inOrder traversal
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> resList = new ArrayList<>();
        if (root1 == null && root2 == null)
            return resList;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        while(root1 != null){
            s1.add(root1);
            root1 = root1.left;
        }
        while(root2 != null){
            s2.add(root2);
            root2 = root2.left;
        }
        while(!s1.isEmpty() || !s2.isEmpty()){
            TreeNode n1 = s1.isEmpty() ? null : s1.peek();
            TreeNode n2 = s2.isEmpty() ? null : s2.peek();
            
            if (n2 == null || n1 != null && n1.val<=n2.val){
                TreeNode temp = s1.pop();
                resList.add(temp.val);
                temp = temp.right;
                while(temp != null){
                    s1.add(temp);
                    temp = temp.left;
                }
                
            }
            else{
                TreeNode temp = s2.pop();
                resList.add(temp.val);
                temp = temp.right;
                while(temp != null){
                    s2.add(temp);
                    temp = temp.left;
                }
            }
        }
        return resList;
        
    }
}
