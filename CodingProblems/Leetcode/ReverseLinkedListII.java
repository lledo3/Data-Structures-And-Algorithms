/*
Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base check
        if(head == null) return null;
        if(head.next == null) return head;
        if(left == right) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        //get to proper starting point
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        
        //needed for final connections
        ListNode connect = prev;
        ListNode tail = curr;
        
        //reverse the nodes
        while(right > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            right--;
        }
        
        //make final connections
        if(connect != null){
            connect.next = prev;
        }else{
            head = prev;
        }
        
        tail.next = curr;
        return head;
    }
}