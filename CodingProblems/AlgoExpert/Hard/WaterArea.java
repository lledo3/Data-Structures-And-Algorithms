/*
PROBLEM:
Given an array of integers representing heights of pillars with constant width 1.
If the area is flooded, return the water area that the pillars will be able to hold.

EXAMPLE:
[0,8,0,0,5,0,0,10,0,0,1,1,0,3] -> 48
               |
   |           |
   |     |     |           ,
 _ | _ _ | _ _ | _ _ | | _ |
   8     5     10    1 1   3

LOGIC:
Traverse Left to Right - find maxLeft
Traverse Right to Left - find maxRight
total capacity at each point = min(left, right) - height [given that min(left, right) > height]

SOLUTION:
1. L to R & vice versa traversal -> time : O(n) | space : O(n)
*/
import java.util.*;

class Program {
  public static int waterArea(int[] heights) {
    // Write your code here.
    int[] maxes = new int[heights.length];
    int leftMax = 0;
    
    for(int i = 0; i < heights.length; i++){
      int height = heights[i];
      maxes[i] = leftMax;
      leftMax = Math.max(leftMax, height);
    }
    int rightMax = 0;
    for(int i = heights.length - 1; i >= 0; i--){
      int height = heights[i];
      int minHeight = Math.min(rightMax, maxes[i]);
      if(height < minHeight){
        maxes[i] = minHeight - height;
      }else{
        maxes[i] = 0;
      }
      rightMax = Math.max(rightMax, height);
    }
    int total = 0;
    for(int i = 0; i < heights.length; i++){
      total += maxes[i];
    }
    return total;
  }
}
