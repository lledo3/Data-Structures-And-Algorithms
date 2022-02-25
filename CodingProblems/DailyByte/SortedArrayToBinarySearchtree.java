/*
Given an array of numbers sorted in ascending order, return a height-balanced binary search tree using every number from the array.
Note: height-balanced meaning that the level of any node’s two subtrees should not differ by more than one.

Ex: Given the following nums...

nums = [1, 2, 3] return a reference to the following tree...
        2
       / \
      1   3
Ex: Given the following nums...

nums = [1, 2, 3, 4, 5, 6] return a reference to the following tree...
        3
       / \
      2   5
     /   / \
    1   4   6
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
public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) {
        return null;
    }

    return buildTree(0, nums.length - 1, nums);
}

public TreeNode buildTree(int left, int right, int[] nums) {
    if(left <= right) {
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(left, mid - 1, nums);
        root.right = buildTree(mid + 1, right, nums);

        return root;
    }

    return null;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of elements in nums. 
Space complexity: O(N) where N is the number of elements in nums because we’re constructor a binary search tree with N values from it.
*/