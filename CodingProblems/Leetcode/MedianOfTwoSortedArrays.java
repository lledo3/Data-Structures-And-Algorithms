/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int pt1 = 0;
        int pt2 = 0;
        int idx = 0;
        
        while(pt1 < m || pt2 < n){
            if(pt1 < m && pt2 < n){
                if(nums1[pt1] < nums2[pt2]){
                    merged[idx++] = nums1[pt1++];
                }else{
                    merged[idx++] = nums2[pt2++];
                }
            }else if(pt1 < m && pt2 >= n){
                merged[idx++] = nums1[pt1++];
            }else{
                merged[idx++] = nums2[pt2++];
            }
        }
            int sum = m + n;
            if((sum) % 2 == 0){
                return (merged[sum / 2] + merged[sum / 2 - 1])/2.0;
            }
        return (double)merged[sum / 2];
    }
}