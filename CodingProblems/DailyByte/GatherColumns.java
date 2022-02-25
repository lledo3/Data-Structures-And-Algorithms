/*
Given a binary tree, return its column order traversal from top to bottom and left to right. 
Note: if two nodes are in the same row and column, order them from left to right.

Ex: Given the following tree…

    8
   / \
  2   29
     /  \
    3    9
return [[2], [8, 3], [29], [9]]
Ex: Given the following tree…

     100
    /   \
  53     78
 / \    /  \
32  3  9    20
return [[32], [53], [100, 3, 9], [78], [20]]
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
    public List<List<Integer>> collectColumns(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        queue.add(root);
        columns.add(0);
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            int column = columns.remove();
            if(!map.containsKey(column)) {
                map.put(column, new ArrayList<Integer>());
            }
            map.get(column).add(current.val);

            if(current.left != null) {
                queue.add(current.left);
                columns.add(column - 1);
                min = Math.min(min, column - 1);
            }
            if(current.right != null) {
                queue.add(current.right);
                columns.add(column + 1);
                max = Math.max(max, column + 1);
            }
        }

        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
/*
Big-O Analysis
Runtime: O(N) where N Is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/