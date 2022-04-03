/*
Write a function that takes in the head of a Singly Linked List, reverses the
list in place (i.e., doesn't create a brand new list), and returns its new head.

Sample Input:
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 

Sample Output:
5 -> 4 -> 3 -> 2 -> 1 -> 0 
*/
import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
    if(head == null) {
			return null;
		}

		LinkedList current = head;
		LinkedList previous = null;
		LinkedList next = null;

		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
