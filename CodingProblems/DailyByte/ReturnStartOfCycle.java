/*
Given a potentially cyclical linked list where each value is unique, return the node at which the cycle starts. 
If the list does not contain a cycle, return null.

Ex: Given the following linked lists...

1->2->3, return null
1->2->3->4->5->2 (5 points back to 2), return a reference to the node containing 2
1->9->3->7->7 (7 points to itself), return a reference to the node containing 7
*/
public ListNode returnStartOfCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            break;
        }
    }

    if (fast == null || fast.next == null) {
        return null;
    }

    slow = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of nodes in our list.
Space complexity: O(1) or constant.
*/