/*
Write a function that returns a boolean representing whether one of nodeOne or nodeThree is an ancestor of
nodeTwo and the other node is a descendant of nodeTwo.

A descendant of a node N is defined as a node contained in the tree rooted at N. A node N is an ancestor
of another node M if M is descendant of N.
*/
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
    // Write your code here.
		if(isDescendant(nodeTwo, nodeOne)){
			return isDescendant(nodeThree, nodeTwo);
		}
		if(isDescendant(nodeTwo, nodeThree)){
			return isDescendant(nodeOne, nodeTwo);
		}
    return false;
  }
	
	public boolean isDescendant(BST node, BST target){
		if(node == null){
			return false;
		}
		
		if(node == target){
			return true;
		}
		
		return (target.value < node.value) ? isDescendant(node.left, target) : isDescendant(node.right, target);
	}
}
