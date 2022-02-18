/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
*/
class Solution {
    public int[][] generateMatrix(int n) {
        //Define variables
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int counter = 1, total = n * n;
        
        //Spiral Traverse
        while(counter <= total){
            //Traverse Left
            for(int i = left; i <= right; i++){
                res[top][i] = counter++;
            }
            top++;
            //Traverse down
            for(int i = top; i <= down; i++){
                res[i][right] = counter++;
            }
            right--;
            //Traverse right
            for(int i = right; i >= left; i--){
                res[down][i] = counter++;
            }
            down--;
            //Traverse top
            for(int i = down; i >= top; i--){
                res[i][left] = counter++;
            }
            left++;
        }
        return res;
    }
}