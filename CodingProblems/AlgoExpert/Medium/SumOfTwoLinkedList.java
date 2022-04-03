/*
You're given two Linked Lists of potentially unequal length. Each Linked List
represents a non-negative integer, where each node in the Linked List is a
digit of that integer, and the first node in each Linked List always
represents the least significant digit of the integer. Write a function that
returns the head of a new Linked List that represents the sum of the integers
represented by the two input Linked Lists.

Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to
None/Null if it's the tail of the list. The value of each LinkedList node is always in the range of 0-9.

Note: your function must create and return a new Linked List, and you're not allowed to modify either of the input Linked Lists.

Sample Input:
linkedListOne = 2 -> 4 -> 7 -> 1
linkedListTwo = 9 -> 4 -> 5

Sample Output:
1 -> 9 -> 2 -> 2
// linkedListOne represents 1742
// linkedListTwo represents 549
// 1742 + 549 = 2291
*/
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList l1, LinkedList l2) {
    // Write your code here.
		LinkedList headPointer = new LinkedList(0);
		LinkedList temp = headPointer;
		int carry = 0;
		while(l1 != null || l2 != null || carry == 1){
			int sum = 0;
			if(l1 != null){
				sum += l1.value;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.value;
				l2 = l2.next;
			}
			sum += carry;
      carry = sum / 10;
			LinkedList node = new LinkedList(sum % 10);
			temp.next = node;
      temp = temp.next;
		}
    return headPointer.next;
  }
}