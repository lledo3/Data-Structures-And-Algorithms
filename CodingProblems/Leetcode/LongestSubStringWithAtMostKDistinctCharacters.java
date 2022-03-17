/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 10^4
0 <= k <= 50
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //base case
        if(k == 0) return 0;
        
        char[] arr = s.toCharArray();
        
        //define pointers
        int L = 0, R = 0;
        
        //define hashmap table
        Map<Character, Integer> map = new HashMap<>();
        
        //define maxLen
        int maxLen = 0;
        int len = arr.length;
        
        //find longest substring with k distinct characters
        while(R < len){
            map.put(arr[R], map.getOrDefault(arr[R], 0) + 1);
            
            //shrink window if we don't mee the condition
            while(map.size() > k){
                map.put(arr[L], map.get(arr[L]) - 1);
                if(map.get(arr[L]) == 0){
                    map.remove(arr[L]);
                }
                L++;
            }
            //update maxLen
            maxLen = Math.max(maxLen, R - L + 1);
            
            //move R pointer to right
            R++;
        }
        return maxLen;
    }
}