/*
Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 

Constraints:

1 <= length <= 50000
At most 50000 calls will be made to set, snap, and get.
0 <= index < length
0 <= snap_id < (the total number of times we call snap())
0 <= val <= 10^9
*/
class SnapshotArray {
    private TreeMap<Integer, Integer>[] maps;  // index: <snap_id, val>
    private int snapIdx;

    // Time complexity: O(N)
    public SnapshotArray(int length) {
        maps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            maps[i] = new TreeMap<>();
            maps[i].put(0, 0);
        }
    }
    
    // Time complexity: O(logN)
    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = maps[index];
        map.put(snapIdx, val);
    }
    
    // Time complexity: O(1)
    public int snap() {
        return snapIdx++;
    }
    
    // Time complexity: O(logN)
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = maps[index];
        return map.floorEntry(snap_id).getValue();
    }
}


// ArrayCopy Solution: no enough memory
// Space complexity: O(N * S), where S is the number of snaps
class SnapshotArray {
    private int snapId;
    private int[] arr;
    private Map<Integer, int[]> map;

    // Time complexity: O(N)
    public SnapshotArray(int length) {
        arr = new int[length];
        map = new HashMap<>();
    }
    
    // Time complexity: O(1)
    public void set(int index, int val) {
        // ask what if index is out of bound.
        arr[index] = val;
    }
    
    // Time complexity: O(N)
    public int snap() {
        int id = snapId;
        snapId++;
        int[] snapArr = new int[arr.length];
        System.arraycopy(arr, 0, snapArr, 0, arr.length);
        map.put(id, snapArr);
        return id;
    }
    
    // Time complexity: O(1)
    public int get(int index, int snap_id) {
        // ask what if snap_id is not exist.
        // ask what if index is out of bound.
        int[] snapArr = map.get(snap_id);
        return snapArr[index];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */