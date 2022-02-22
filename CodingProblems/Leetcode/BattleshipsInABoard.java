/*
Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the 
shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or 
vertical cell separates between two battleships (i.e., there are no adjacent battleships).

Example 1:

Input: board = [["X",".",".","X"],
				[".",".",".","X"],
				[".",".",".","X"]]
Output: 2

Example 2:

Input: board = [["."]]
Output: 0
 
Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.
*/
class Solution {
    public int countBattleshipsRecur(char[][] board) {
        int numBattleShips = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X')
                    numBattleShips++;
                    sinkBattleship(board, i, j);
            }
        }
        return numBattleShips;
    }
    
    public void sinkBattleship(char[][] board, int i, int j){
        //check bounds
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'X'){
            return;
        }
        
        board[i][j] = '.';
        sinkBattleship(board, i + 1, j);
        sinkBattleship(board, i - 1, j);
        sinkBattleship(board, i, j + 1);
        sinkBattleship(board, i, j - 1);
    }

    public int countBattleships(char[][] board) {
        int numBattleShips = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    continue;   
                }
                if(i > 0 && board[i - 1][j] == 'X'){
                    continue;
                }
                if(j > 0 && board[i][j - 1] == 'X'){
                    continue;
                }
                numBattleShips++;
            }
        }
        return numBattleShips;
    }
}