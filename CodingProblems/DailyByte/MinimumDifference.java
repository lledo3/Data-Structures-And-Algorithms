/*
Given a binary search tree, return the minimum difference between any two nodes in the tree.

Ex: Given the following tree...
        2
       / \
      3   1
return 1.
Ex: Given the following tree...
        29
       /  \
     17   50
    /     / \
   1    42  59
return 8.
Ex: Given the following tree...
        2
         \
         100
return 98.
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
public int minimumDifference(TreeNode root) {
    List<Integer> inorder = new ArrayList<Integer>();
    inorder(root, inorder);

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < inorder.size() - 1; i++) {
        min = Math.min(min, inorder.get(i + 1) - inorder.get(i));
    }

    return min;
}

public void inorder(TreeNode root, List<Integer> inorder) {
    if(root == null) {
        return;
    }

    inorder(root.left, inorder);
    inorder.add(root.val);
    inorder(root.right, inorder);
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/