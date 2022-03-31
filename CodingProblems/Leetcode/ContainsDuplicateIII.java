/*
Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in 
the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 

Constraints:

1 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^4
0 <= t <= 2^31 - 1
*/
class Solution {
	//navie approach: TC: O(n min(k,n)) SC: O(1)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (Math.abs((long) nums[i] - nums[j]) <= t) return true;
            }
        }
        return false;
    }
}

class Solution {
	// TC: O(n log(min(n,k))) SC: O(min(n,k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
         /**case to Long to avoid Integer overflow.*/
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; ++i) {
                Long s = set.ceiling((long) nums[i]);
                if (s != null && s - nums[i] <= t) {
                    return true;
                }

                Long g = set.floor((long) nums[i]);
                if (g != null && nums[i] - g <= t) {
                    return true;
                }

                set.add((long) nums[i]);
                if (set.size() > k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
    }
}