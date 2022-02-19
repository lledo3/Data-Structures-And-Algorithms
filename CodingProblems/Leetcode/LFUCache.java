/*
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. 
The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 

Constraints:

0 <= capacity <= 10^4
0 <= key <= 10^5
0 <= value <= 10^9
At most 2 * 105 calls will be made to get and put.
*/
class LFUCache {
    Map<Integer, Integer> keyValueMap = new HashMap<>();
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    Map<Integer, Set<Integer>> freqMap = new HashMap<>();
    int cap;
    int min = -1;
    
    public LFUCache(int capacity) {
        cap = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!keyValueMap.containsKey(key))
            return -1;
        // Get the current key's freq
        int freq = keyFreqMap.get(key);

        // Update current key's freq
        keyFreqMap.put(key, freq + 1);
        freqMap.get(freq).remove(key);

        // Update the min freq
        if (freq == min && freqMap.get(freq).size() == 0)
            min++;

        // Update current key's freq
        if (!freqMap.containsKey(freq + 1))
            freqMap.put(freq + 1, new LinkedHashSet<>());
        freqMap.get(freq + 1).add(key);

        return keyValueMap.get(key);
    }
    
    public void put(int key, int value) {
        // Base case
        if (cap == 0)
            return;

        // Update value
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);// update the freq for the current key
        } else {
            // Check if exceed the capacity
            if (keyValueMap.size() == cap) {
                Set<Integer> curlist = freqMap.get(min);
                int top = poll(curlist);
                keyValueMap.remove(top);// remove lfu
            }
            keyValueMap.put(key, value);
            keyFreqMap.put(key, 1);
            min = 1;// because we just add a new element
            freqMap.get(1).add(key);
        }
    }
    
    public Integer poll(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        Integer top = iterator.next();
        set.remove(top);
        return top;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */