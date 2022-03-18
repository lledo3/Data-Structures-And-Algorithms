/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n^2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
*/
class Solution {
	//brute force
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n * n];
        int idx = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                arr[idx] = matrix[i][j];
                idx++;
            }
        }
        Arrays.sort(arr);
        
        return arr[k - 1];
    }
}
/*-----------------------------------------------------------*/
class Solution {
	//merge sort TC: O(nlog(max-min)), SC:O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n - 1][n - 1];
        
        while(min != max){
            int mid = min + (max - min) / 2;
            int count = getCount(matrix, mid);
            if(count < k){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    public int getCount(int[][] matrix, int mid){
        int count = 0;
        int col = matrix.length - 1;
        int row = 0;
        
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] <= mid){
                count += col + 1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
}