/*
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
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
    public ListNode rotateRight(ListNode head, int k) {
        //base case
        if(head == null || head.next == null || k == 0) return head;
        
        //get length of linked list
        int len = 0;
        ListNode cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        
        len++;
        cur.next = head;
        k = k % len; //if k is larger than the list
        k = len - k; //find the cut point
        while(k > 0){
            cur = cur.next;
            k--;
        }
        
        head = cur.next;
        cur.next = null;
        
        return head;
    }
}