/*
Given a binary search tree, return its mode (you may assume the answer is unique). 
If the tree is empty, return -1. Note: the mode is the most frequently occurring value in the tree.

Ex: Given the following tree...

        2
       / \
      1   2
return 2.

Ex: Given the following tree...

         7
        / \
      4     9
     / \   / \
    1   4 8   9
               \
                9  
return 9.
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
public int findMode(TreeNode root) {
    int result = -1;
    if(root == null) {
        return result;
    }

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    inorder(root, map);

    int max = Integer.MIN_VALUE;
    for(int key: map.keySet()) {
          int count = map.get(key); 
          if (count > max) {
            max = count;
            result = key;
        }
    }

    return result;
}

public void inorder(TreeNode root, HashMap<Integer, Integer> map) {
    if(root.left != null) {
        inorder(root.left, map);
    }

    map.put(root.val, map.getOrDefault(root.val, 0) + 1);

    if(root.right != null) {
        inorder(root.right, map);
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree. 
Space complexity: O(N) where N is the number of nodes in our tree.
*/