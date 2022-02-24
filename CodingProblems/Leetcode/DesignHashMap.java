/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:

0 <= key, value <= 10^6
At most 104 calls will be made to put, get, and remove.
*/
class MyHashMap {
    private static final int numOfBuckets = 1337;
    private Node[] buckets = null;
    private static class Node {
        private Node next;
        private int key;
        private int value;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[numOfBuckets];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        Node currNode = buckets[index];
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }
        while (currNode.next != null) {
            if (currNode.key == key) {
                currNode.value = value;
                return;
            }
            currNode = currNode.next;
        }
        if (currNode.key == key) {
            currNode.value = value;
        } else {
            currNode.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        Node currNode = buckets[index];
        while (currNode != null) {
            if (currNode.key == key) {
                return currNode.value;
            }
            currNode = currNode.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (get(key) == -1) {
            return;
        }
        int index = hash(key);
        Node currNode = buckets[index];
        Node nextNode = buckets[index].next;
        if (buckets[index].key == key) {
            buckets[index] = buckets[index].next;
            return;
        }
        while (nextNode != null) {
            if (nextNode.key == key) {
                currNode.next = nextNode.next;
                return;
            }
            currNode = nextNode;
            nextNode = nextNode.next;
        }
    }
    
    private static int hash(int key) {
        return key % numOfBuckets;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */