/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
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
    public List<Integer> postorderTraversal(TreeNode root) {
    	//recursively
        return postorderTraversalHelperDfs(root, new ArrayList());
    }
    
    public List<Integer> postorderTraversalHelperDfs(TreeNode root, List<Integer> result){
        if(root == null) return result;
        
        postorderTraversalHelperDfs(root.left, result);
        postorderTraversalHelperDfs(root.right, result);
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversalItera(TreeNode root){
    	//Iterative
    	List<Integer> result = new ArrayList();
    	Stack<TreeNode> stack = new Stack();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode curr = stack.pop();
            if(curr != null){
                //add value at the 0th index every time which will shift values to the right
                result.add(0, curr.val);
                if(curr.left != null){
                    stack.push(curr.left);
                }
                if(curr.right != null){
                    stack.push(curr.right);
                }
            }
    	}
    	return result;
    }
}