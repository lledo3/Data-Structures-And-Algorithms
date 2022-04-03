/*
PROBLEM:
Find max path sum of a binary tree.
A path is collection of connected nodes where no node is connected to more than two nodes.

LOGIC:
Each node can either be
- root
- part of path
Maintain Max globalRoot

SOLUTION:
1. Recursion : time - O(n) | space - O(log n)
*/
import java.util.*;

class Program {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
    List<Integer> maxSumArray = findMaxSum(tree);
		return maxSumArray.get(1);
  }
	
	public static List<Integer> findMaxSum(BinaryTree tree){
		if(tree == null){
			return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
		}
		List<Integer> leftMax = findMaxSum(tree.left);
		Integer leftMaxSumBranch = leftMax.get(0);
		Integer leftMaxPathSum = leftMax.get(1);
		
		List<Integer> rightMax = findMaxSum(tree.right);
		Integer rightMaxSumBranch = rightMax.get(0);
		Integer rightMaxPathSum = rightMax.get(1);
		
		Integer maxChildSum = Math.max(leftMaxSumBranch, rightMaxSumBranch);
		Integer maxSumBranch = Math.max(maxChildSum + tree.value, tree.value);
		Integer maxSumRootNode = Math.max(leftMaxSumBranch + tree.value + rightMaxSumBranch, maxSumBranch);
		int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum,maxSumRootNode));
		
		return new ArrayList<Integer>(Arrays.asList(maxSumBranch, maxPathSum));
	}

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
