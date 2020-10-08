/*

1612. Check If Two Expression Trees are Equivalent
Medium

A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (variables), and internal nodes (nodes with two children) correspond to the operators. In this problem, we only consider the '+' operator (i.e. addition).

You are given the roots of two binary expression trees, root1 and root2. Return true if the two binary expression trees are equivalent. Otherwise, return false.

Two binary expression trees are equivalent if they evaluate to the same value regardless of what the variables are set to.

Follow up: What will you change in your solution if the tree also supports the '-' operator (i.e. subtraction)?

Example 1:

Input: root1 = [x], root2 = [x]
Output: true

Example 2:

Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,b,c,a]
Output: true
Explaination: a + (b + c) == (b + c) + a

Example 3:

Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,b,d,a]
Output: false
Explaination: a + (b + c) != (b + d) + a

Constraints:

    The number of nodes in both trees are equal, odd and, in the range [1, 4999].
    Node.val is '+' or a lower-case English letter.
    It's guaranteed that the tree given is a valid binary expression tree.

*/

/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character,Integer> map = new HashMap<>();
        fillMap(root1, map);
        return checkMap(root2, map);
    }
    
    private boolean checkMap(Node node, Map<Character,Integer> map){
        if(node == null) return true;
        if(node.val != '+'){
            if(!map.containsKey(node.val) || map.get(node.val) < 0) return false;
            map.put(node.val, map.get(node.val) - 1);
            if(map.get(node.val) < 0) return false;
        }
        return checkMap(node.left, map) && checkMap(node.right, map);
    }
    
    private void fillMap(Node node, Map<Character,Integer> map){
        if(node == null) return;
        if(node.val != '+')
            map.put(node.val, map.containsKey(node.val) ? map.get(node.val) + 1 : 1);
        fillMap(node.left, map);
        fillMap(node.right, map);
    }
}

/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character,Integer> map = new HashMap<>();
        fillMap(root1, map);
        boolean[] res = new boolean[]{true};
        checkMap(root2, map, res);
        return res[0];
    }
    
    private void checkMap(Node node, Map<Character,Integer> map, boolean[] res){
        if(node == null) return;
        char val = node.val;
        if(node.val != '+'){
            if(!map.containsKey(node.val) || map.get(node.val) < 0) {
                res[0] = false;
                if(res[0] == false) return;
            }
            map.put(node.val, map.get(node.val) - 1);
            if(map.get(node.val) < 0){
                if(res[0] == false) return;
                res[0] = false;
            }
        }
        checkMap(node.left, map, res);
        checkMap(node.right, map, res);
    }
    
    private void fillMap(Node node, Map<Character,Integer> map){
        if(node == null) return;
        if(node.val != '+')
            map.put(node.val, map.containsKey(node.val) ? map.get(node.val) + 1 : 1);
        fillMap(node.left, map);
        fillMap(node.right, map);
    }
}

