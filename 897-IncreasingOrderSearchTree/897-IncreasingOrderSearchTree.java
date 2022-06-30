/*

897. Increasing Order Search Tree
Easy

Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  

Note:

    The number of nodes in the given tree will be between 1 and 100.
    Each node will have a unique integer value from 0 to 1000.

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
    public TreeNode increasingBST(TreeNode root) {
        //Store inorder traversal into a list
        // create a tree with left = null and right = next value in list
        List<Integer> tempList = new ArrayList<>();
        getInorderTraversal(root, tempList);
        TreeNode curr = new TreeNode(0), ans = curr;
        for (int t : tempList){
            curr.right = new TreeNode(t);
            curr.left = null;
            curr = curr.right;
        }
        return ans.right;
    }
    private void getInorderTraversal(TreeNode root, List list){
        if (root == null)
            return;
        getInorderTraversal(root.left, list);
        list.add(root.val);
        getInorderTraversal(root.right, list);
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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr = new TreeNode(0);
        TreeNode ans = curr;
        getInorderTraversal(root);
        return ans.right;
    }
    private void getInorderTraversal(TreeNode root){
        if (root == null)
            return;
        getInorderTraversal(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        getInorderTraversal(root.right);
    }
}

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        // Using Stack
        Stack<TreeNode> s = new Stack<>();
        TreeNode nr = new TreeNode();
        TreeNode ret = nr;
        while(root != null){
            s.push(root);
            root = root.left;
        }
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            nr.right = new TreeNode(curr.val);
            nr = nr.right;
            if(curr.right != null){
                curr = curr.right;
                s.push(curr);
                while(curr.left != null){
                    s.push(curr.left);
                    curr = curr.left;
                }
            }
        }
        return ret.right;
        
    }
}
