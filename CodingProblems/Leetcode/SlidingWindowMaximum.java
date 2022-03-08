/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/
//Brute-force: O(n*k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n * k == 0){
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        
        for(int i = 0; i < n - k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}

//Optimal: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int left = 0;
        int right = 0;
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        while(right < n){
            //expand window
            while(!deque.isEmpty() && deque.peekLast() < nums[right]){
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            
            //shrink window
            if(k <= right - left + 1){
                //get max in current window
                result.add(deque.peekFirst());
                
                //update the deque
                if(deque.peekFirst() == nums[left++]){
                    deque.pollFirst();
                }
            }
            right++;
        }
        //convert to int[]
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}