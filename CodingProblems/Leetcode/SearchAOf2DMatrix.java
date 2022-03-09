/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols - 1;
        
        //implement binary search
        while(left <= right){
            int mid = left + (right - left) / 2;
            int element = matrix[mid / cols][mid % cols]; //2d matrix computation
            
            if(element == target){
                return true;
            }else if(element < target){ //means the element is not the left side
                left = mid + 1;
            }else{ 
                right = mid - 1;  //means the element is not on the right side
            }
        }
        return false;
    }
}