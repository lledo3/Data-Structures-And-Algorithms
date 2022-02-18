/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
*/
class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        //setup board
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        placeQueen(res, board, 0);
        return res.size();
    }
    
    public void placeQueen(List<List<String>> res, char[][] board, int row){
        if(row == board.length){//base condition - return
            res.add(buildBoard(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            //check if position is valid
            if(isValidQueenPlacement(board, row, col)){
                board[row][col] = 'Q'; //place queen
                placeQueen(res, board, row + 1); //move to next cell
                board[row][col] = '.'; //backtracking undo placement
            }
        }
    }
    
    public boolean isValidQueenPlacement(char[][] board, int row, int col){
        //check rows for current column
        for(int r = 0; r < row; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }
        
        //check diagonal on right side
        for(int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        
        //check diagonal on left side
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public List<String> buildBoard(char[][] board){
        List<String> l = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            l.add(new String(board[i]));
        }
        return l;
    }
}