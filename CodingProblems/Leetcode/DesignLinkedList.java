/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the 
current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous 
node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, 
the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
*/
class MyLinkedList {
  class Node {
    public int val;
    public Node next;
    public Node(int val) { this.val = val; this.next = null; }
    public Node(int val, Node next) { this.val = val; this.next = next; }
  }
  
  private Node head;
  private Node tail;
  private int size;
  
  public MyLinkedList() {
    this.head = this.tail = null;
    this.size = 0;
  }
  
  private Node getNode(int index) {
    Node n = new Node(0, this.head);
    while (index-- >= 0) {
      n = n.next;
    }
    return n;
  }
 
  public int get(int index) {
    if (index < 0 || index >= size) return -1;
    return getNode(index).val;
  }
 
  public void addAtHead(int val) {
    this.head = new Node(val, this.head);
    if (this.size++ == 0)
      this.tail = this.head;    
  }
 
  public void addAtTail(int val) {
    Node n = new Node(val);
    if (this.size++ == 0)
      this.head = this.tail = n;
    else
      this.tail = this.tail.next = n;
  }
 
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > this.size) return;
    if (index == 0)  { this.addAtHead(val); return; }
    if (index == size) { this.addAtTail(val); return; }
    Node prev = this.getNode(index - 1);
    prev.next = new Node(val, prev.next);
    ++this.size;
  }
 
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= this.size) return;
    Node prev = this.getNode(index - 1);
    prev.next = prev.next.next;
    if (index == 0) this.head = prev.next;
    if (index == this.size - 1) this.tail = prev;
    --this.size;
  }
}