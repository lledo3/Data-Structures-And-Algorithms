/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] 
is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:

Input: nums = [-1]
Output: [0]

Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
*/
class Solution {
    int[] count;//store jump
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        count = new int[nums.length];
        int[] idx = new int[nums.length];
        
        for(int i =0; i < nums.length; i++){
            idx[i] = i;
        }
        sort(nums, idx, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            result.add(count[i]);
        }
        
        return result;
    }
    public void sort(int[] nums, int[] idx, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            sort(nums, idx, left, mid);
            sort(nums, idx, mid + 1, right);
            merge(nums, idx, left, mid, right);
        }
    }
    public void merge(int[] nums, int[] idx, int left, int mid, int right){
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;
        
        int[] leftArray = new int[leftArrSize];
        int[] rightArray = new int[rightArrSize];
        
        for(int i = 0; i < leftArrSize; i++){
            leftArray[i] = idx[left + i];
        }
        
        for(int i = 0; i < rightArrSize; i++){
            rightArray[i] = idx[i + mid + 1];
        }
        int i = 0, j = 0, k = left, rightCount = 0;
        
        while(i < leftArrSize && j < rightArrSize){
            if(nums[leftArray[i]] <= nums[rightArray[j]]){
                idx[k] = leftArray[i];
                count[leftArray[i]] += rightCount;
                i++;
            }else{
                idx[k] = rightArray[j];
                rightCount++;
                j++;
            }
            k++;
        }
        while(i < leftArrSize){
            idx[k] = leftArray[i];
            count[leftArray[i]] += rightCount;
            i++;
            k++;
        }
        while(j < rightArrSize){
            idx[k] = rightArray[j];
            j++;
            k++;
        }
    }
}