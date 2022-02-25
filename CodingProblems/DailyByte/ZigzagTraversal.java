/*
Given a binary tree, return its zig-zag level order traversal 
(i.e. its level order traversal from left to right the first level, right to left the level the second, etc.).

Ex: Given the following tree…

    1
   / \
  2   3
return [[1], [3, 2]]
Ex: Given the following tree…

    8
   / \
  2  29
    /  \
   3    9
return [[8], [29, 2], [3, 9]]
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
public List<List<Integer>> zigzagTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root == null) {
        return result;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int count = 0;
    while(!queue.isEmpty()) {
        int size = queue.size();
        Deque<Integer> level = new LinkedList<Integer>();
        for(int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            if(count % 2 == 0) {
                level.addLast(current.val);
            } else {
                level.addFirst(current.val);
            }

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        count++;
        result.add(new ArrayList<Integer>(level));
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/