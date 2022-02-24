/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. 
You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 2^31 - 1
*/
class Solution {
    public int[][] DIRECTIONS = {
        {1, 0},//down direction
        {-1, 0},//up direction
        {0, 1},//right direction
        {0, -1}//left direction
    };
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int longestPath = 0;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int longest = longestIncreasingPathDfs(matrix, dp, row, col, i, j);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }
    
    public int longestIncreasingPathDfs(int[][] matrix, int[][] dp, int row, int col, int i, int j){
        if(dp[i][j] > 0) return dp[i][j];
        int max = 0;
        for(int[] direction : DIRECTIONS){
            int x = direction[0] + i, y = direction[1] + j;
            if(x > -1 && y > -1 && x < row && y < col && matrix[x][y] > matrix[i][j]){
                int longest = longestIncreasingPathDfs(matrix, dp, row, col, x, y);
                max = Math.max(longest, max);
            }
        }
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}