/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

//Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
    	//recursively
        return preorderTraversalHelperDfs(root, new ArrayList());
    }
    
    public List<Integer> preorderTraversalHelperDfs(TreeNode root, List<Integer> result){
        if(root == null) return result;
        
        result.add(root.val);
        preorderTraversalHelperDfs(root.left, result);
        preorderTraversalHelperDfs(root.right, result);
        return result;
    }

    public List<Integer> preorderTraversalItera(TreeNode root){
    	//Iterative
    	List<Integer> result = new ArrayList();
    	Stack<TreeNode> stack = new Stack();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode curr = stack.pop();
    		if(curr != null){
    			result.add(curr.val);
    			stack.push(curr.right);
    			stack.push(curr.left);
    		}
    	}
    	return result;
    }
}