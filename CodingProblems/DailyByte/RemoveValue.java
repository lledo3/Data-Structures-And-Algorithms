/*
Given a linked list and a value, remove all nodes containing the provided value, and return the resulting list.

Ex: Given the following linked lists and values...

1->2->3->null, value = 3, return 1->2->null
8->1->1->4->12->null, value = 1, return 8->4->12->null
7->12->2->9->null, value = 7, return 12->2->9->null
*/
public ListNode removeValue(ListNode head, int val) {
    while(head != null && head.val == val) {
        head = head.next;
    }

    ListNode dummy = head;
    while(dummy != null) {
        if(dummy.next != null && dummy.next.val == val) {
            dummy.next = dummy.next.next;
        } else {
            dummy = dummy.next;
        }
    }

    return head;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our list.
Space complexity: O(1) or constant
*/