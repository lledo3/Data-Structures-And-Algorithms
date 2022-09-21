/*
Given an N-ary tree, return its maximum depth.
Note: An N-ary tree is a tree in which any node may have at most N children.

Ex: Given the following tree…

            4
          / | \
         3  9  2
        /       \
       7         2
return 3.
*/
public int maxDepth(Node root) {
    if(root == null) {
        return 0;
    }

    int max = 0;
    for(Node child: root.children) {
        max = Math.max(max, maxDepth(child));
    }

    return max + 1;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of nodes in our tree.
Space complexity: O(N) where N is the total number of nodes in our tree. This extra space results from our recursion.
*/