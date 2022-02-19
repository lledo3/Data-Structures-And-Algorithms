/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 
Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inOrder(root, sortedList, k);
        return sortedList.get(k - 1);
    }
    public void inOrder(TreeNode root, List<Integer> sortedList, int k){
        if(sortedList.size() == k) return;
        
        if(root.left == null && root.right == null){
            sortedList.add(root.val);
            return;
        }
        
        if(root.left != null){
            inOrder(root.left, sortedList, k);
        }
        sortedList.add(root.val);
        if(root.right != null){
            inOrder(root.right, sortedList, k);
        }
    }
}