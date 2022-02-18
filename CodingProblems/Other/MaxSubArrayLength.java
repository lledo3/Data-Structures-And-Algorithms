/*
* Find a subarray of maximum length such that the product of all the elements in the subarray is 1.

Sample input:
array size: n = 6
array = [1, -1, -1, -1, 1, 1]

Sample output:
4

Explanation:
These are a few of the subarrays whose product is equal to 1:
Subarray with indices from (0,2), length of the subarray is 3
Subarray with indices from (1,2), length of the subarray is 2
Subarray with indices from (2,5), length of the subarray is 4
Subarray with indices from (4,5), length of the subarray is 2
*
* */

public class MaxSubArrayLength {
	public static void main(String[] args) {
        int[] nums = {1, -1, -1, -1, 1, 1};
        System.out.println(maxSubArrayLength(nums));
    }
    public static int maxSubArrayLength(int[] arr){
        if(arr.length == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;

        for(int i = 0; i < arr.length; i++){
            int product = 1;
            for(int j = i; j < arr.length; j++){
                product = product * arr[j];
                if(product == 1){
                    curLen = j - i + 1;
                    maxLen = Math.max(maxLen, curLen);
                }else{
                    curLen = 0;
                }
            }
        }
        return maxLen;
    }
}