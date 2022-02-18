/*
Non Overlapping Intervals - O(n log n)

Given a collection of intervals, find the maximum number of non-overlapping intervals you can select.


Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 3
Explanation: [1,2], [2, 3] and [3, 4] are non-overlapping.

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Your algorithm should run in O(n log n) time and use O(1) extra space.
*/
class Solution {

    public int nonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> first[1] - second[1]);
        int result = 1, lastTaken = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[lastTaken][1]) {
                result++;
                lastTaken = i;
            }
        }
        return result;
    }
}