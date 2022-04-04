/*
Your music player contains n different songs. You want to listen to goal songs (not necessarily different) during your trip. 
To avoid boredom, you will create a playlist so that:

Every song is played at least once.
A song can only be played again only if k other songs have been played.
Given n, goal, and k, return the number of possible playlists that you can create. Since the answer can be very large, return it modulo 109 + 7.

Example 1:

Input: n = 3, goal = 3, k = 1
Output: 6
Explanation: There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].

Example 2:

Input: n = 2, goal = 3, k = 0
Output: 6
Explanation: There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].

Example 3:

Input: n = 2, goal = 3, k = 1
Output: 2
Explanation: There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].
 

Constraints:

0 <= k < n <= goal <= 100
*/
//TC: O(ngoal) SC: O(ngoal)
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[goal+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; ++i)
            for (int j = 1; j <= n; ++j) {
                dp[i][j] += dp[i-1][j-1] * (n-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-k, 0);
                dp[i][j] %= MOD;
            }

        return (int) dp[goal][n];
    }
}
/*
Intuition

Let dp[i][j] be the number of playlists of length i that have exactly j unique songs. We want dp[L][N], and it seems 
likely we can develop a recurrence for dp.

Algorithm

Consider dp[i][j]. Last song, we either played a song for the first time or we didn't. If we did, then we had dp[i - 1][j - 1] * (N - j + 1) 
ways to choose it. If we didn't, then we repeated a previous song in dp[i-1][j] * max(j-K, 0) ways (j of them, except the last K ones played 
are banned.)
*/