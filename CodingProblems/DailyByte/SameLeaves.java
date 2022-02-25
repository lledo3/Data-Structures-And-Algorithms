/*
Given two binary trees, return whether or not both trees have the same leaf sequence. 
Two trees have the same leaf sequence if both trees’ leaves read the same from left to right.

Ex: Given the following trees…

   1
 /   \
1     3
and


   7
 /   \
1     2

return false as both the trees' leaves don't read the same from left to right (i.e. [1, 3] and [1, 2]).
Ex: Given the following trees…

    8
   / \
  2   29
    /  \
   3    9
and

    8
   / \
  2  29
 /   /  \
2   3    9
     \
      3
return true as both the trees' leaves read the same from left to right (i.e. [2, 3, 9] and [2, 3, 9]).
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public boolean sameLeaves(TreeNode root1, TreeNode root2) {
    List<Integer> root1Leaves = new ArrayList<>();
    collectLeaves(root1, root1Leaves);

    List<Integer> root2Leaves = new ArrayList<>();
    collectLeaves(root2, root2Leaves);

    return root1Leaves.equals(root2Leaves);
}

public void collectLeaves(TreeNode root, List<Integer> leaves) {
    if (root != null) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/