/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/
 //Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        
        ListNode pt1 = small;
        ListNode pt2 = large;
        
        while(head != null){
            if(head.val < x){
                //add the val into small list
                pt1.next = head;
                pt1 = pt1.next;
            }else{
                //add the val into large list
                pt2.next = head;
                pt2 = pt2.next;
            }
            //move head pointer to the next node
            head = head.next;
        }
        //connect the two partitions together
        pt2.next = null;
        pt1.next = large.next;
        
        return small.next;
    }
}