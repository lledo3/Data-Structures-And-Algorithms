/*
Write a function that returns the values of all the nodes that are exactly
distance k from the node with target value.

The distance between two nodes is defined as the number of edges that must be
traversed to go from one node to the other. For example, the distance between
a node and its immediate left or right child is 1. The same holds in reverse: 
the distance between a node and its parent is 1. In a tree of three nodes where 
the root node has a left and right child, the left and right children are distance
2 from each other.

Sample Input
tree  = 
			 1
     /   \
    2     3
  /   \     \
 4     5     6
           /   \
          7     8

target = 3
k = 2

Sample Output:
[2, 7, 8] // These values could be ordered differently.
*/
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    // Write your code here.
		ArrayList<Integer> nodesDisK = new ArrayList<>();
		findDis(tree, target, k, nodesDisK);
    return nodesDisK;
  }
	
	public int findDis(BinaryTree node, int target, int k, ArrayList<Integer> nodesDisK){
		if(node == null) return -1;
		
		if(node.value == target){
			addSubtree(node, 0, k, nodesDisK);
			return 1;
		}
		
		int leftDis = findDis(node.left, target, k, nodesDisK);
		int rightDis = findDis(node.right, target, k, nodesDisK);
		
		if(leftDis == k || rightDis == k) nodesDisK.add(node.value);
		
		if(leftDis != -1){
			addSubtree(node.right, leftDis + 1, k, nodesDisK);
			return leftDis + 1;
		}
		
		if(rightDis != -1){
			addSubtree(node.left, rightDis + 1, k, nodesDisK);
			return rightDis + 1;
		}
		return -1;
	}
	
	public void addSubtree(BinaryTree node, int distance, int k, ArrayList<Integer> nodesDisK){
		if(node == null) return;
		
		if(distance == k){
			nodesDisK.add(node.value);
		}else{
			addSubtree(node.left, distance + 1, k, nodesDisK);
			addSubtree(node.right, distance + 1, k, nodesDisK);
		}
	}
}