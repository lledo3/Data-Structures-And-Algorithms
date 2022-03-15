/*

  You're given a Node  class that has a name  and an array of optional children  nodes. When put together, nodes form
  an acyclic tree-like structure. Implement the breadthFirstSearch method on the Node  class, which takes in an empty array, 
  traverses the tree using the Breadth-first Search approach (specifically navigating the tree from left to right), stores 
  all of the nodes' names in the input array, and returns it.

example 1
   =    A
     /  |  \
    B   C   D
   / \     / \
  E   F   G   H
     / \   \
    I   J   K

output: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"]

*/
import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> breadthFirstSearch(List<String> array) {
      // Write your code here.
			Queue<Node> q = new LinkedList<Node>();
			q.add(this);
			while(!q.isEmpty()){
				Node tempNode = q.poll();
				array.add(tempNode.name);
				q.addAll(tempNode.children);
			}
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
