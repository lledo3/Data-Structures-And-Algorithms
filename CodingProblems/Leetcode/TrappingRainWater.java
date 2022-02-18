/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
*/
class Solution {
    /*public int trap(int[] height) {
        int max = 0;
        int len = height.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(height[max] < height[i]){
                max = i;
            }
        }
        int leftMax = 0;
        for(int i = 0; i < max; i++){
            if(height[leftMax] < height[i]){
                leftMax = i; 
            }
            sum += Math.min(height[leftMax], height[max]) - height[i];
        }
        int rightMax = len - 1;
        for(int i = len - 1; i > max; i--){
            if(height[rightMax] < height[i]){
                rightMax = i;
            }
            sum += Math.min(height[max], height[rightMax]) - height[i];
        }
        return sum;
    }*/
    public int trap(int[] height){
        int i = 0;
        int j = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;
        
        while(i < j){
            if(height[i] <= height[j]){
                maxLeft = Math.max(maxLeft, height[i]);
                water += maxLeft - height[i];
                i++;
            }else{
                maxRight = Math.max(maxRight, height[j]);
                water += maxRight - height[j];
                j--;
            }
        }
        return water;
    }
}