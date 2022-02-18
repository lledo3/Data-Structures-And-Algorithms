/*
Longest Consecutive Sequence - O(n log n)

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: Longest consecutive sequence is [1, 2, 3, 4].
             Therefore its length is 4.

Note:
For this lesson, your algorithm should run in O(n log n) time and use O(1) extra space.
(There are faster solutions which we will discuss in future lessons)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        //Add the nums to hash set which help for retriving and checking
        HashSet<Integer> numbers = new HashSet<>();
        for(int num : nums){
            numbers.add(num);
        }
        int longestSequence = 0;
        
        for(int i = 0; i < nums.length; i++){
            //check if number is the start of a sequence
            int currSum = nums[i];
            int currentSequence = 1;
            if(!numbers.contains(currSum - 1)){
                while(numbers.contains(currSum + 1)){
                    currSum += 1;
                    currentSequence += 1;
                }
                longestSequence = Math.max(longestSequence, currentSequence);
            }
            
        }
        return longestSequence;
    }
}