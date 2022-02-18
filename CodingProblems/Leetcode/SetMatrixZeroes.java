/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        
        for(int j = 0; j < col; j++){
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
        
        
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
        
        if(firstRow){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
        
        if(firstCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        
        /*for(int[] test : matrix){
            System.out.println(Arrays.toString(test));
        }*/
    }
}