/*
You're given a two-dimensional array (a matrix) of distinct integers and a
target integer. Each row in the matrix is sorted, and each column is also sorted; the
matrix doesn't necessarily have the same height and width.

Write a function that returns an array of the row and column indices of the
target integer if it's contained in the matrix, otherwise [-1,-1].

Sample Input:

matrix = [
  [1, 4, 7, 12, 15, 1000],
  [2, 5, 19, 31, 32, 1001],
  [3, 8, 24, 33, 35, 1002],
  [40, 41, 42, 44, 45, 1003],
  [99, 100, 103, 106, 128, 1004],
]

Sample Output:
[3, 3]
*/
import java.util.*;

class Program {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    // Write your code here.
    int col = matrix[0].length - 1;
    int row = 0;

		while (row < matrix.length && col > -1){
			if (target < matrix[row][col]){ 
				col -= 1; 
			}else if (target > matrix[row][col]){
			 row += 1; 
			}else{ 
				return new int[] {row, col}; 
			}
		}

		return new int[] {-1, -1};
  }
}
