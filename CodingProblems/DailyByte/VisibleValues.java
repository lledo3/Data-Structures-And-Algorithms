/*
Given a binary tree return all the values you’d be able to see if you were standing on the left side of it with values ordered from top to bottom.

Ex: Given the following tree…

-->    4
      / \
-->  2   7
return [4, 2]
Ex: Given the following tree…

-->        7
         /  \
-->     4     9
       / \   / \
-->   1   4 8   9
                 \
-->               9
return [7, 4, 1, 9]
*/
public List<Integer> visibleValues(TreeNode root) {
    List<Integer> visibleValues = new ArrayList<>();
    if(root == null) {
        return visibleValues;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            TreeNode current = queue.remove();
            if(i == 0) {
                visibleValues.add(current.val);
            }
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    return visibleValues;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/