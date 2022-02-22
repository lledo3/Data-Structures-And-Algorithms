/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
    public ListNode sortList(ListNode head) {
        //base case
        if(head == null || head.next == null) return head;
        
        //split in the middle
        ListNode l1 = head, l2 = splitMidNode(head);
        
        //sort the left list
        l1 = sortList(l1);
        
        //sort the right list
        l2 = sortList(l2);
        
        //Merge the lists together
        ListNode dummy = new ListNode(), res = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if(l2 != null){
            res.next = l2;
        }else{
            res.next = l1;
        }
        //return the head node
        return dummy.next;
    }
    
    public ListNode splitMidNode(ListNode head){
        ListNode slow = head, fast = head, pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
}