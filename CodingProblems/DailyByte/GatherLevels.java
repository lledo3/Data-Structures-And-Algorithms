/*
Given a binary tree, return its level order traversal where the nodes in each level are ordered from left to right.

Ex: Given the following tree...
    4
   / \
  2   7
return [[4], [2, 7]]

Ex: Given the following tree...
    2
   / \
  10  15
        \
         20
return [[2], [10, 15], [20]]

Ex: Given the following tree...

    1
   / \
  9   32
 /      \
3        78
return [[1], [9, 32], [3, 78]]
*/
public List<List<Integer>> gatherLevels(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if(root == null) {
        return levels;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            currentLevel.add(current.val);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

        levels.add(currentLevel);
    }

    return levels;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree. 
Space complexity: O(N) where N is the number of nodes in our tree.
*/