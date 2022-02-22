/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4
*/
class Solution {
    //TC: O(n) SC: O(n)
    public int candy(int[] ratings) {
        int candy = 0, len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        //fill arrays with default value of one
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        //left relative array
        for(int i = 1; i < len; i++){
            //if current index rating > previous : give extra candy
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }
        
        //right relative array
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
        }
        
        for(int i = 0; i < len; i++){
            candy = candy + Math.max(left[i], right[i]);
        }
        return candy;
    }
}