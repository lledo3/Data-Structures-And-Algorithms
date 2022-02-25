/*
Given two sorted linked lists, merge them together in ascending order and return a reference to the merged list

Ex: Given the following lists...

list1 = 1->2->3, list2 = 4->5->6->null, return 1->2->3->4->5->6->null
list1 = 1->3->5, list2 = 2->4->6->null, return 1->2->3->4->5->6->null
list1 = 4->4->7, list2 = 1->5->6->null, return 1->4->4->5->6->7->null
*/

 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public ListNode mergeLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode head = dummy;
    while(l1 != null && l2 != null) {
        if(l1.val < l2.val) {
            dummy.next = l1;
            l1 = l1.next;
        } else {
            dummy.next = l2;
            l2 = l2.next;
        }
        dummy = dummy.next;
    }

    if(l1 != null) {
        dummy.next = l1;
    } else {
        dummy.next = l2;
    }

    return head.next;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in both of our lists. 
Space complexity: O(1) or constant as we only create one new node dummy before merging our two lists together.
*/