/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 

Constraints:

1 <= nums1.length, nums2.length <= 10^5
-10^9 <= nums1[i], nums2[i] <= 10^9
nums1 and nums2 both are sorted in ascending order.
1 <= k <= 10^4
*/
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<> ();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<> ((arr1, arr2) -> arr1[0] + arr1[1] - arr2[0] - arr2[1]);
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer (new int[] {nums1[i], nums2[0], 0});
        }
        
        while (k-- != 0 && !minHeap.isEmpty ()) {
            int[] curr = minHeap.poll ();
            pairs.add (List.of (curr[0], curr[1]));
            if (curr[2] + 1 < nums2.length) {
                minHeap.offer (new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
            }
        }
        
        return pairs;
    }
}