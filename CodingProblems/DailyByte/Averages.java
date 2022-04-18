/*
Given a reference to the root of a binary tree, return a list containing the average value in each level of the tree.

Ex: Given the following binary tree…

       1
      / \
    6    8
   / \ 
  1   5 
return [1.0, 7.0, 3.0]
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
public List<Double> averageOfLevels(TreeNode root) {
    List<Double> averages = new ArrayList<Double>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while(!queue.isEmpty()) {
        int size = queue.size();
        double sum = 0;
        for(int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            sum += current.val;
            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }

        averages.add(sum / size);
    }

    return averages;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of nodes in our tree.
Space complexity: O(N) where N is the total number of nodes in our tree. This results from utilizing a queue for our breadth-first search.
*/