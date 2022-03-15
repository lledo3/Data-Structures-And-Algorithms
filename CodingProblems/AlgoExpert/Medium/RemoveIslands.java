/*
  You're given a two-dimensional array (a matrix) of potentially unequal height
  and width containing only 0s and 1s. The matrix represents a two-toned image, 
  where each 1 represents black and each 0 represents white. An island is defined 
  as any number of 1s that are horizontally or vertically adjacent (but not
  diagonally adjacent) and that don't touch the border of the image. In other
  words, a group of horizontally or vertically adjacent 1s isn't an
  island if any of those 1s are in the first row, last row, first
  column, or last column of the input matrix.

  Note that an island can twist. In other words, it doesn't have to be a
  straight vertical line or a straight horizontal line; it can be L-shaped, for
  example.


  You can think of islands as patches of black that don't touch the border of
  the two-toned image.

  Write a function that returns a modified version of the input matrix, where
  all of the islands are removed. You remove an island by replacing it with
  0s.

Naturally, you're allowed to mutate the input matrix.

Sample Input: matrix = 
[
  [1, 0, 0, 0, 0, 0],
  [0, 1, 0, 1, 1, 1],
  [0, 0, 1, 0, 1, 0],
  [1, 1, 0, 0, 1, 0],
  [1, 0, 1, 1, 0, 0],
  [1, 0, 0, 0, 0, 1],
]

Sample Output: <pre>[
  [1, 0, 0, 0, 0, 0],
  [0, 0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1, 0],
  [1, 1, 0, 0, 1, 0],
  [1, 0, 0, 0, 0, 0],
  [1, 0, 0, 0, 0, 1],
] 
// The islands that were removed can be clearly seen here:</span>
// [
//   [ ,  ,  ,  ,  , ],
//   [ , 1,  ,  ,  , ],
//   [ ,  , 1,  ,  , ],
//   [ ,  ,  ,  ,  , ],
//   [ ,  , 1, 1,  , ],
//   [ ,  ,  ,  ,  , ],
// ]
*/
import java.util.*;

class Program {

  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
    for(int row = 0; row < matrix.length; row++){
      for(int col = 0; col < matrix[row].length; col++){
        boolean rowBorder = row == 0 || row == matrix.length - 1;
        boolean colBorder = col == 0 || col == matrix[row].length - 1;
        boolean isBorder = rowBorder || colBorder;
        
        if(!isBorder){
          continue;
        }
        if(matrix[row][col] != 1){
          continue;
        }
        changeBorderOnesToTwos(matrix, row, col);
      }
    }
    for(int row = 0; row < matrix.length; row++){
      for(int col = 0; col < matrix[row].length; col++){
        int color = matrix[row][col];
        if(color == 1){
          matrix[row][col] = 0;
        }else if(color == 2){
          matrix[row][col] = 1;
        }
      }
    }
    return matrix;
  }
  
  public void changeBorderOnesToTwos(int[][] matrix, int row, int col){
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] {row, col});
    
    while(stack.size() > 0){
      int[] currPos = stack.pop();
      int currRow = currPos[0];
      int currCol = currPos[1];
      
      matrix[currRow][currCol] = 2;
      
      int[][] neighbors = getNeighbors(matrix, currRow, currCol);
      for(int[] neighbor : neighbors){
        int r = neighbor[0];
        int c = neighbor[1];
        
        if(matrix[r][c] != 1){
          continue;
        }
        stack.push(neighbor);
      }
    }
  }
  public int[][] getNeighbors(int[][] matrix, int row, int col){
    int numRows = matrix.length;
    int numCols = matrix[row].length;
    
    List<int[]> temp = new ArrayList<>();
    
    if(row - 1 >= 0){
      temp.add(new int[] {row - 1, col}); //up
    }
    if(row + 1 < numRows){
      temp.add(new int[] {row + 1, col}); //down
    }
    if(col - 1 >= 0){
      temp.add(new int[] {row, col - 1}); //left
    }
    if(col + 1 < numCols){
      temp.add(new int[] {row, col + 1}); //right
    }
    int[][] neighbors = new int[temp.size()][2];
    for(int i = 0; i < temp.size(); i++){
      neighbors[i] = temp.get(i);
    }
    return neighbors;
  }
}
