/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] 
represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west 
if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to 
both the Pacific and Atlantic oceans.

Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 10^5
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0){
            return new ArrayList<List<Integer>>();
        }
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        
        //top and bottom
        for(int col = 0; col < heights[0].length; col++){
            dfs(heights, 0, col, Integer.MIN_VALUE, pacific);
            dfs(heights, heights.length - 1, col, Integer.MIN_VALUE, atlantic);
        }
        
        //left and right
        for(int row = 0; row < heights.length; row++){
            dfs(heights, row, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, row, heights[0].length - 1, Integer.MIN_VALUE, atlantic);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    LinkedList<Integer> sol = new LinkedList<Integer>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            } 
        }
        
        return res;
    }
    
    public static void dfs(int[][] matrix, int row, int col, int prevVal, int[][] ocean){
        //1. Check conditions
        if(row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1){
            return;
        }
        if(matrix[row][col] < prevVal){
            return;
        }
        if(ocean[row][col] == 1){
            return;
        }
        
        //2. Process
        ocean[row][col] = 1;
        
        //3. call dfs
        dfs(matrix, row - 1, col, matrix[row][col], ocean);
        dfs(matrix, row + 1, col, matrix[row][col], ocean);
        dfs(matrix, row, col - 1, matrix[row][col], ocean);
        dfs(matrix, row, col + 1, matrix[row][col], ocean);
        
        
    }
}