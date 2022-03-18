/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 10^5
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> map.get(n1) - map.get(n2));
        
        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: map.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }
        
        // 3. build an output array
        // O(k log k) time
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            result[i] = heap.poll();
        }
        return result;
    }
}