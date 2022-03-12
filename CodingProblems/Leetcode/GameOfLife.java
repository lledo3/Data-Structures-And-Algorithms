/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician 
John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. 
Given the current state of the m x n grid board, return the next state.

Example 1:

Input: board = [[0,1,0],
				[0,0,1],
				[1,1,1],
				[0,0,0]]

Output:board = [[0,0,0],
				[1,0,1],
				[0,1,1],
				[0,1,0]]

Example 2:

Input: board = [[1,1],
				[1,0]]

Output:board = [[1,1],
				[1,1]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
 

Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their 
updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active 
area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
*/
class Solution {
    int[][] directions = new int[][]{
            {-1,-1},//up-left diagonal direction
            {1,1},//down-right diagonal direction
            {-1,0},//up direction
            {1,0},//down direction
            {-1,1},//up-right diagonal direction
            {1,-1},//down-left diagonal direction
            {0,-1},//left direction
            {0,1}//right direction
        };
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                for(int[] direction : directions){
                    int x = i + direction[0];
                    int y = j + direction[1];
                    
                    if(x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)){
                        count++;
                    }
                }
                //2 means: it was alive but now its dead
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 2;
                    }
                }
                //3 means: it was dead but now its alive
                else{
                    if(count == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //do mod 2 because if it's 1 it will remain 1, if its 3 it will be 1 and if its 2 it will be 0
                board[i][j] %= 2;
            }
        }
    }
}