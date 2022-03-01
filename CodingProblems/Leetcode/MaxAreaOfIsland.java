/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
			   [0,0,0,0,0,0,0,1,1,1,0,0,0],
			   [0,1,1,0,1,0,0,0,0,0,0,0,0],
			   [0,1,0,0,1,1,0,0,1,0,1,0,0],
			   [0,1,0,0,1,1,0,0,1,1,1,0,0],
			   [0,0,0,0,0,0,0,0,0,0,1,0,0],
			   [0,0,0,0,0,0,0,1,1,1,0,0,0],
			   [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/
class Solution {
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        seen = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                max = Math.max(max, maxAreaOfIslandDfs(grid, i, j));
            }
        }
        return max;
    }
    
    public int maxAreaOfIslandDfs(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || seen[row][col] || grid[row][col] == 0){
            return 0;
        }
        seen[row][col] = true;
        return (1 + maxAreaOfIslandDfs(grid, row + 1, col) + maxAreaOfIslandDfs(grid, row - 1, col) +
                    maxAreaOfIslandDfs(grid, row, col - 1) + maxAreaOfIslandDfs(grid, row, col + 1));
    }
}