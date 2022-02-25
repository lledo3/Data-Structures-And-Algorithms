/*
Given a binary tree, return the largest value in each of its levels. Ex: Given the following tree…

    2
   / \
  10  15
        \
         20
return [2, 15, 20]
Ex: Given the following tree…

          1
         / \
        5   6
       / \   \  
      5   3   7 
return [1, 6, 7]
*/
public List<Integer> maxValueInLevels(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null) {
        return result;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int size = 1;
    while(!queue.isEmpty()) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++) {
            TreeNode node = queue.remove();
            max = Math.max(max, node.val);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }

        size = queue.size();
        result.add(max);   
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/