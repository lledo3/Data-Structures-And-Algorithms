/*
You are given an m x n binary matrix image where 0 represents a white pixel and 1 represents a black pixel.

The black pixels are connected (i.e., there is only one black region). Pixels are connected horizontally and vertically.

Given two integers x and y that represents the location of one of the black pixels, return the area of the smallest (axis-aligned) 
rectangle that encloses all black pixels.

You must write an algorithm with less than O(mn) runtime complexity

Example 1:

Input: image = 
[
["0","0","1","0"],
["0","1","1","0"],
["0","1","0","0"]
], 
x = 0, y = 2
Output: 6

Example 2:

Input: image = [["1"]], x = 0, y = 0
Output: 1
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 100
image[i][j] is either '0' or '1'.
1 <= x < m
1 <= y < n
image[x][y] == '1'.
The black pixels in the image only form one component.
*/
class Solution {
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = row == 0 ? 0 : image[0].length;
        
        if(col == 0) return 0;
        
        int up = row - 1;
        int down = 0;
        int left = col - 1;
        int right = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(image[i][j] == '1'){
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return (down - up + 1) * (right - left + 1);
    }
}