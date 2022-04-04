/*
You are given an m x n matrix board, representing the current state of a crossword puzzle. 
The crossword contains lowercase English letters (from solved words), ' ' to represent any empty cells, and '#' to represent any blocked cells.

A word can be placed horizontally (left to right or right to left) or vertically (top to bottom or bottom to top) in the board if:

It does not occupy a cell containing the character '#'.
The cell each letter is placed in must either be ' ' (empty) or match the letter already on the board.
There must not be any empty cells ' ' or other lowercase letters directly left or right of the word if the word was placed horizontally.
There must not be any empty cells ' ' or other lowercase letters directly above or below the word if the word was placed vertically.
Given a string word, return true if word can be placed in board, or false otherwise.

Example 1:

Input: board = [["#", " ", "#"], [" ", " ", "#"], ["#", "c", " "]], word = "abc"
Output: true
Explanation: The word "abc" can be placed as shown above (top to bottom).

Example 2:

Input: board = [[" ", "#", "a"], [" ", "#", "c"], [" ", "#", "a"]], word = "ac"
Output: false
Explanation: It is impossible to place the word because there will always be a space/letter above or below it.

Example 3:

Input: board = [["#", " ", "#"], [" ", " ", "#"], ["#", " ", "c"]], word = "ca"
Output: true
Explanation: The word "ca" can be placed as shown above (right to left). 
 

Constraints:

m == board.length
n == board[i].length
1 <= m * n <= 2 * 10^5
board[i][j] will be ' ', '#', or a lowercase English letter.
1 <= word.length <= max(m, n)
word will contain only lowercase English letters.
*/
class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] array = word.toCharArray();
        int[][] direcs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == array[0] || board[i][j] == ' ') {
                    if ((board[0].length - j >= array.length && (j == 0 || board[i][j - 1] == '#') 
                            && placeWordInCrossword(board, array, i, j, 0, direcs[0]))
                        || (board.length - i >= array.length && (i == 0 || board[i - 1][j] == '#') 
                            && placeWordInCrossword(board, array, i, j, 0, direcs[1]))
                        || (j + 1 >= array.length && (j == board[0].length - 1 || board[i][j + 1] == '#') 
                            && placeWordInCrossword(board, array, i, j, 0, direcs[2]))
                        || (i + 1 >= array.length && (i == board.length - 1 || board[i + 1][j] == '#') 
                            && placeWordInCrossword(board, array, i, j, 0, direcs[3]))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean placeWordInCrossword(char[][] board, char[] array, int row, int col, int index, int[] direc) {
        if (index == array.length) {
            return row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == '#';
        }
        else {
            if ( 0 <= row && row < board.length && 0 <= col && col < board[0].length 
                    && (board[row][col] == array[index] || board[row][col] == ' ')) {
                return placeWordInCrossword(board, array, row + direc[0], col + direc[1], index + 1, direc);
            }
            else {
                return false;
            }
        }
    }
}