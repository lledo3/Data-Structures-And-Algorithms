/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

 

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(word.charAt(0) == board[i][j] && searchWordExistDfs(i, j , 0, board, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchWordExistDfs(int i, int j, int idx, char[][] board, String word){
        if(idx == word.length()){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j]){
            return false;
        }
        
        //temp variable to remember the position
        char temp = board[i][j];
        //make an empty space so that the char is not used again
        board[i][j] = ' ';
        //search for word recursively
        boolean found = searchWordExistDfs(i + 1, j, idx + 1, board, word) ||
           searchWordExistDfs(i - 1, j, idx + 1, board, word) ||
           searchWordExistDfs(i, j + 1, idx + 1, board, word) ||
           searchWordExistDfs(i, j - 1, idx + 1, board, word);
        
        //add temp variable back in original position
        board[i][j] = temp;
        
        return found;
    }
}