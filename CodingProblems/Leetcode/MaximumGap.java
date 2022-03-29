/*
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. 
If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
*/
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int n = nums.length;
        int max = nums[0], min= nums[0];
        for(int i  : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int bucketSize = (max - min)/(n - 1);
        if(bucketSize == 0)
            bucketSize++;
        int totalBuckets = ((max - min)/bucketSize) + 1;
        int[] minBucket = new int[totalBuckets];
        int[] maxBucket = new int[totalBuckets];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        for(int i = 0 ; i < n ; i++) {
            int index = (nums[i] - min)/bucketSize;
            minBucket[index] = Math.min(minBucket[index], nums[i]);
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
        }
        int prevMax = maxBucket[0], result = 0;
        for(int i = 1; i < totalBuckets; i++) {
            if(minBucket[i] == Integer.MAX_VALUE)
                continue;
            result = Math.max(result, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }
        return result;
    }
}