/*
Given a binary search tree, rearrange the tree such that it forms a linked list where all its values are in ascending order.

Ex: Given the following tree...
        5
       / \
      1   6
return...
1
 \
  5
   \
    6

Ex: Given the following tree...
       5
      / \
    2    9
   / \ 
  1   3 
return...
1
 \
  2
   \
    3
     \
      5
       \
        9

Ex: Given the following tree...
        5
         \
          6
return...
5
 \
  6
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
public TreeNode convertBSTToSortedLinkedList(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    inorder(root, values);
    TreeNode result = new TreeNode();
    TreeNode current = result;
    for (int value: values) {
        current.right = new TreeNode(value);
        current = current.right;
    }

    return result.right;
}

public void inorder(TreeNode root, List<Integer> values) {
    if (root == null) {
        return;
    }

    inorder(root.left, values);
    values.add(root.val);
    inorder(root.right, values);
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree. 
Space complexity: O(N) where N is the number of nodes in our tree.
*/