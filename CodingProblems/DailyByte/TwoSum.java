/*
Given an array of integers, return whether or not two numbers sum to a given target, k.
Note: you may not sum a number with itself.

Ex: Given the following...

[1, 3, 8, 2], k = 10, return true (8 + 2)
[3, 9, 13, 7], k = 8, return false
[4, 2, 6, 5, 2], k = 4, return true (2 + 2)
*/
public boolean twoSum(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == k) {
                return true;
            }
        }
    }

    return false;
}
/*
Big-O Analysis
Runtime: O(n^2)
*/
public boolean twoSum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
        int difference = k - nums[i];
        if(set.contains(difference)) {
            return true;
        }

        set.add(nums[i]);
    }

    return false;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of integers in our list
Space complexity: O(N) because we use a hash map to store all N numbers in the worst case
*/