/*

297. Serialize and Deserialize Binary Tree
Hard

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

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
public class Codec {
    
    // bfs approach
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return "";
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp == null){
                sb.append("null,");
                continue;
            }
            else
                sb.append(Integer.valueOf(temp.val)).append(",");
            q.add(temp.left);
            q.add(temp.right);
        }
        return sb.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] terms = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(terms[0]));
        q.add(root);
        for(int i = 1; i<terms.length; i++){
            TreeNode temp = q.poll();
            if (!terms[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(terms[i]));
                temp.left = left;
                q.add(left);
            }
            if (!terms[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(terms[i]));
                temp.right = right;
                q.add(right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //DFS approach
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfsSer(root, sb);
        return sb.toString();
    }
    private void dfsSer(TreeNode node, StringBuilder sb){
        if (node == null)
            sb.append("null,");
        else{
            sb.append(node.val).append(",");
            dfsSer(node.left, sb);
            dfsSer(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return dfsDe(q);
    }
    private TreeNode dfsDe(Queue q){
        String val = String.valueOf(q.poll());
        if(val.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = dfsDe(q);
        root.right = dfsDe(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
