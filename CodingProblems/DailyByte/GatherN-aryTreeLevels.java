/*
Given an n-ary tree, return its level order traversal.
Note: an n-ary tree is a tree in which each node has no more than N children.

Ex: Give the following n-ary tree…

    8
  / | \
 2  3  29
return [[8], [2, 3, 29]]
Ex: Given the following n-ary tree…

     2
   / | \
  1  6  9
 /   |   \
8    2    2
   / | \
 19 12 90
return [[2], [1, 6, 9], [8, 2, 2], [19, 12, 90]]
*/
/**
 * Definition for a Node.
 * public class Node {
 *     int val;
 *     public Node() {}
 *     
 *     public Node(int _val,List<Node> _children) {
 *           val = _val;
 *           children = _children;
 *     }
 * }
 */    
public List<List<Integer>> getNaryTreeLevels(Node root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if(root == null) {
        return levels;
    }

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            Node current = queue.remove();
            level.add(current.val);
            queue.addAll(current.children);
        }

        levels.add(level);
    }

    return levels;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our tree.
Space complexity: O(N) where N is the number of nodes in our tree.
*/