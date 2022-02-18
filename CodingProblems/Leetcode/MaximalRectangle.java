/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:

Input: matrix = [["0"]]
Output: 0

Example 3:

Input: matrix = [["1"]]
Output: 1

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    height[j] = 0;
                 }else{
                    height[j] += 1;
                }
            }
            max = Math.max(max, findTheArea(height));
        }
        return max;
    }
    
    public int findTheArea(int[] h){
        int max = 0;
        Stack<Integer> s = new Stack<>();
        s.add(0);
        
        for(int i = 1; i < h.length; i++){
            int curr = h[i];
            if(s.isEmpty() || curr >= h[s.peek()]){
                s.add(i);
            }else{
                while(!s.isEmpty() && curr < h[s.peek()]){
                    int temp = h[s.pop()];
                    if(s.isEmpty()){
                        max = Math.max(max, temp * i);
                    }else{
                        max = Math.max(max, temp * (i - s.peek() - 1));
                    }
                }
                s.add(i);
            }
        }
        //possiblity that height was ever increasing, if the stack is not empty
        if(!s.isEmpty()){
            while(!s.isEmpty()){
                int i = h.length;
                int temp = h[s.pop()];
                if(s.isEmpty()){
                    max = Math.max(max, temp * i);
                }else{
                    max = Math.max(max, temp * (i - s.peek() - 1));
                }
            }
        }
        return max;
    }
}