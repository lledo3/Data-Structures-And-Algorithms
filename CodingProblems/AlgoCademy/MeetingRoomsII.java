/*
Meeting Rooms II - O(n log n)

Given an array consisting of meeting time intervals, which are represented by the start and end times ([s0, e0], [s1, e1], ...], 
determine the minimum number of meeting rooms needed in order to be able to accomodate all meetings at every moment of time.

Example:

Input: [[5, 10], [0, 30], [15, 20]]
Output: 2
Explanation: 1st and 3rd meetings can be assigned to the first room
             2nd meeting can be assigned to room 2
 

Note:

You may assume the interval's end point is always greater than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap.

Your algorithm should run in O(n log n) time and use O(n) extra space.
*/
class Solution {
    public int meetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, (int[]a,int[]b) -> a[0] - b[0]);
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        
        min_heap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= min_heap.peek()) {
                min_heap.poll();
            }
            min_heap.add(intervals[i][1]);
        }
        return min_heap.size();
    }
}