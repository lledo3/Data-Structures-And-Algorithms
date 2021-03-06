/*
You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward 
you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards 
from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.

Example 1:

Input: nums = [2,-1,1,2,2]
Output: true
Explanation:
There is a cycle from index 0 -> 2 -> 3 -> 0 -> ...
The cycle's length is 3.

Example 2:

Input: nums = [-1,2]
Output: false
Explanation:
The sequence from index 1 -> 1 -> 1 -> ... is not a cycle because the sequence's length is 1.
By definition the sequence's length must be strictly greater than 1 to be a cycle.

Example 3:

Input: nums = [-2,1,-1,-2,-2]
Output: false
Explanation:
The sequence from index 1 -> 2 -> 1 -> ... is not a cycle because nums[1] is positive, but nums[2] is negative.
Every nums[seq[j]] must be either all positive or all negative.
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0
 

Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity?
*/
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length <= 1){
            return false;
        }
        
        for(int i = 0; i < nums.length; i++){
            //setup two pointers
            int slow = i;
            int fast = i;
            boolean direction = nums[i] > 0;
            
            while(true){
                slow = getNextPosition(nums, slow, direction);
                if(slow == -1){
                    break;
                }
                fast = getNextPosition(nums, fast, direction);
                if(fast == -1){
                    break;
                }
                fast = getNextPosition(nums, fast, direction);
                if(fast == -1){
                    break;
                }
                if(slow == fast){
                    return true;
                }
            }
        }
        return false;
    }
    public int getNextPosition(int[] nums, int pointer, boolean direction){
    	//get the direction from the pointer
        boolean dir = nums[pointer] >= 0;
        //if the directions are not the same return -1
        if(dir != direction){
            return -1;
        }
        //this means that I will get the next index: example if pointer is 4 and nums[pointer] is 2 and the length of the array is 5 (4 + 2) % 5 -> 6%5 is index 1
        int nextIdx = (pointer + nums[pointer]) % nums.length;
        //checking if it is negative number
        if(nextIdx < 0){
            nextIdx = nextIdx + nums.length;
        }
        if(nextIdx == pointer){
            return -1;
        }
        return nextIdx;
    }
}