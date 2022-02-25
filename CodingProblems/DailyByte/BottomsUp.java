/*
Given a binary tree, returns of all its levels in a bottom-up fashion (i.e. last level towards the root). Ex: Given the following tree…

        2
       / \
      1   2
return [[1, 2], [2]]
Ex: Given the following tree…

       7
      / \
    6    2
   / \ 
  3   3 
return [[3, 3], [6, 2], [7]]
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
public List<List<Integer>> bottomUpTraversal(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if(root == null) {
        return levels;
    }

    Stack<List<Integer>> stack = new Stack<>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()) {
        List<Integer> level = new ArrayList<Integer>();
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            level.add(current.val);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
        stack.add(level);
    }

    while (!stack.isEmpty()) {
        levels.add(stack.pop());
    }

    return levels;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/