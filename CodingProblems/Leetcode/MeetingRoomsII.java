/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        if(intervals.length == 0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        for(int i = 0, j = 0; i < intervals.length; i++){
            if(start[i] >= end[j]){
                j++;
            }else{
                count += 1;
            }
        }
        return count;
    }
}