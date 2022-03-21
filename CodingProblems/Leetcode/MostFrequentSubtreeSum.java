/*
Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

Example 1:

Input: root = [5,2,-3]
Output: [2,-3,4]

Example 2:

Input: root = [5,2,-5]
Output: [2]
 

Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-10^5 <= Node.val <= 10^5
*/
//Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
     if( root == null ){
            return new int[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[ (int)1e4 + 1 ];
        
        dfs(root,map);
        
		// bucket array ( frequency ) stores all the sum having that frequency
        for( int sum : map.keySet() ){
            int freq = map.get(sum);
            if( bucket[freq] == null ){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(sum);
        }
        
        for( int i = bucket.length-1 ; i>=0 ; i-- ){
            if( bucket[i] != null ){
                int[] res = new int[ bucket[i].size() ];
                for( int j = 0 ; j < bucket[i].size() ; j++ ){
                    res[j] = bucket[i].get(j);
                }
                return res;
            }
        }
        return new int[0];
    }
    public int dfs( TreeNode root , HashMap<Integer,Integer> map ){
        if( root == null ) return 0;
        
        int left  = dfs( root.left  , map );
        int right = dfs( root.right , map );
        int sum = left + right + root.val;
        
		// make frequency map
        if( !map.containsKey(sum) ){
            map.put( sum , 0 );
        }
        map.put( sum , map.get(sum) + 1 );
        
        return sum;
    }
}