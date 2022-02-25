/*
 Given a non-empty linked list, return the middle node of the list. If the linked list 
 contains an even number of elements, return the node closer to the end.
Ex: Given the following linked lists...

1->2->3->null, return 2
1->2->3->4->null, return 3
1->null, return 1
*/
public ListNode findMiddleElement(ListNode head) {
    int count = 0;
    ListNode dummy = head;
    while (dummy != null) {
        dummy = dummy.next;
        count++;
    }

    for (int i = 0; i < count / 2; i++) {
        head = head.next;
    }

    return head;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our list.
Space complexity: O(1) or constant.
*/