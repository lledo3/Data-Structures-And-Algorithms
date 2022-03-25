/*
You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, 
and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number 
of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. 
Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.

Return the maximum sum of values that you can receive by attending events.

Example 1:

Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

Example 2:

Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.

Example 3:

Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9
Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.
 

Constraints:

1 <= k <= events.length
1 <= k * events.length <= 10^6
1 <= startDayi <= endDayi <= 10^9
1 <= valuei <= 10^6
*/
class Solution {
    public int maxValue(int[][] events, int k) {
        // sort based on the first number
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int [][] dp = new int [n][k + 1];
        int max = 0;
        // our possiblity:
        // -> skip the event and start with the next event with no change in profit
        // -> consider this event, add profit and move on to next non overlapping event
        for (int i=0; i<n; i++) {
            max = Math.max(max, events[i][2]);
            dp[i][1] = events[i][2];
        }
        if (k == 1)
            return max;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                // non overlapping
                if (events[j][1] < events[i][0]) {
                    for (int x=2; x<=k; x++) {
                        dp[i][x] = Math.max(dp[i][x], dp[j][x-1] + events[i][2]);
                    }
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<=k; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}