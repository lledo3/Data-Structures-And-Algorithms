/*
Given an integer array, two players take turns picking the largest number from the ends of the array. First, player one picks a number 
(either the left end or right end of the array) followed by player two. Each time a player picks a particular numbers, it is no longer 
available to the other player. This picking continues until all numbers in the array have been chosen. Once all numbers have been picked, 
the player with the larger score wins. Return whether or not player one will win.

Note: You may assume that each player is playing to win (i.e. both players will always choose the maximum of the two numbers each turn) 
and that there will always be a winner.

Ex: Given the following integer array...

nums = [1, 2, 3], return true
Player one takes 3
Player two takes 2
Player one takes 1
3 + 1 > 2 and therefore player one wins
*/
public boolean findTheWinner(int[] nums) {
    int[][] memoize = new int[nums.length][nums.length];
    if (play(nums, 0, nums.length - 1, memoize) >= 0) {
        return true;
    }

    return false;
}

public int play(int[] nums, int start, int end, int[][] memoize) {
    if (start == end) {
        return nums[start];
    }
    if (memoize[start][end] != 0) {
        return memoize[start][end];
    }

    int left = nums[start] - play(nums, start + 1, end, memoize);
    int right = nums[end] - play(nums, start, end - 1, memoize);
    memoize[start][end] = Math.max(left, right);
    return memoize[start][end];
}
/*
Big-O Analysis
Runtime: O(N2) where N is the total number of elements in nums.
Space complexity: O(N2) where N is the total number of elements in nums. This results from our 2D matrix (which is size N x N).
*/