/*
Leetcode 285
In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the smallest key greater than the key of the input
node. Given  anode inputNode in a BST, you're asked to write a function findInorderSuccessor that returns the Inorder Successor of the
inputNode. If inputNode has no Inorder Successor, return nul.

example 1:

	   20
      / \
    9    25
   / \ 
  5   12
      / \
    11  14

In this diagram, the inorder successor of 9 is 11 and the inorder successor of 14 is 20

inputNode key = 11
Return: key = 12

Constraints:
[time limit] 5000ms
[input] Node inputNode
[output] Node
*/
//Definition for a binary tree node.
  public class Node {
      int key;
      Node left;
      Node right;
      Node parent;
      
      Node(int key) {
          this.key = key;
          this.left = null;
          this.right = null;
          this.parent = null
      }
  }

  static class BinarySearchTree {
  	Node root;

  	Node findInorderSuccessor(Node inputNode){
  		if(inputNode.right != null){
  			return getMostLeft(inputNode.right);
  		}

  		Node parent = inputNode.parent;
  		Node child = inputNode;

  		while(parent.right == child){
  			if(parent.parent == null)
  				return null;

  			child = parent;
  			parent = parent.parent;
  		}

  		return parent;
  	}

  	Node getMostLeft(Node x){
  		if(x.left == null){
  			return x;
  		}
  		return getMostLeft(x.left);
  	}

  }