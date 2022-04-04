/*
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'

Example 1:

Input: matrix = 
[
[0,1,0],
[1,1,1],
[0,1,0]
], 
target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.

Example 2:

Input: matrix = 
[
[1,-1],
[-1,1]
], 
target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

Example 3:

Input: matrix = [[904]], target = 0
Output: 0
*/
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;

        for(int i = 0; i<matrix[0].length;i++){//left col
            int[] sum = new int[matrix.length];
            for(int m = i; m<matrix[0].length;m++){//right col
                for(int j = 0; j<matrix.length;j++){
                    sum[j]+=matrix[j][m];//add left to right
                    if(sum[j]==target)ans++;            
                }
                for(int j = 0; j<matrix.length;j++){//up row
                    int summe=0;    
                    for(int n = j; n<matrix.length;n++){//down row
                        summe+=sum[n];//add up to down
                        if(n!=j&&summe==target)ans++;
                    }
                }
            }
        }
        
        return ans;

    }
}