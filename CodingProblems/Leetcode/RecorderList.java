/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 10^4].
1 <= Node.val <= 1000
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //head of firs half
        ListNode l1 = head;
        //head of second half
        ListNode slow = head;
        //tail of second half
        ListNode fast = head;
        //tail of first half
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode nexNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexNode;
        }
        return prev;
    }
    
    public void merge(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode l1Nex = l1.next;
            ListNode l2Nex = l2.next;
            
            l1.next = l2;
            
            if(l1Nex == null){
                break;
            }
            l2.next = l1Nex;
            l1 = l1Nex;
            l2 = l2Nex;
        }
    }
}