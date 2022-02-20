/*
Given an integer array nums and an integer k, return true if it is possible to divide 
this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 10^4
The frequency of each element is in the range [1, 4].
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        if(totalSum % k != 0 || k > nums.length) return false;
        
        int subSetSum = totalSum / k;
        Arrays.sort(nums);
        reverse(nums);
        boolean[] visited = new boolean[nums.length];
        return partitionBacktracking(nums, visited, 0, k, 0, subSetSum);
        
    }
    
    public boolean partitionBacktracking(int[] nums, boolean[] visited, int start, int k, int currSum, int subSetSum){
        if (k == 0) return true;
        if(currSum > subSetSum) return false;
        if(currSum == subSetSum){
            return partitionBacktracking(nums, visited, 0, k - 1, 0, subSetSum);
        }
        
        for(int i = start; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(partitionBacktracking(nums, visited, i + 1, k, currSum + nums[i], subSetSum)) return true;
            visited[i] = false;
        }
        return false;
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}