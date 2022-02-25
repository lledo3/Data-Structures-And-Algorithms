/*
Given a binary tree, return a list of strings containing all root to leaf paths.

Ex: Given the following tree…

   1
 /   \
2     3
return ["1->2", "1->3"]
Ex: Given the following tree…

    8
   / \
  2  29
    /  \
   3    9
return ["8->2", "8->29->3", "8->29->9"]
*/
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public List<String> rootToLeafPaths(TreeNode root) {
    List<String> paths = new ArrayList<String>();
    if(root == null) {
        return paths;
    }

    generatePaths(root, paths, "");
    return paths;
}

public void generatePaths(TreeNode root, List<String> paths, String current) {
    if(root.left == null && root.right == null) {
        current += root.val;
        paths.add(current);
        return;
    }

    if(root.left != null) {
        generatePaths(root.left, paths, current + root.val + "->");
    }

    if(root.right != null) {
        generatePaths(root.right, paths, current + root.val + "->");
    }
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/