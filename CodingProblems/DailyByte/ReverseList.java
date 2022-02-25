/*
Given a linked list, containing unique values, reverse it, and return the result.

Ex: Given the following linked lists...

1->2->3->null, return a reference to the node that contains 3 which points to a list that looks like the following: 3->2->1->null
7->15->9->2->null, return a reference to the node that contains 2 which points to a list that looks like the following: 2->9->15->7->null
1->null, return a reference to the node that contains 1 which points to a list that looks like the following: 1->null
*/
public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = previous;
        previous = head;
        head = next;
    }

    return previous;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our list. 
Space complexity: O(1) or constant.
*/