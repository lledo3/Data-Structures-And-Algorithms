/*
Given a string s, return the length of the longest substring that contains at most two distinct characters.

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.

Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
 

Constraints:

1 <= s.length <= 10^5
s consists of English letters
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //base case
        char[] c = s.toCharArray();
        int len = c.length;
        if(len < 3) return len;
            
        //define pointers
        int L = 0, R = 0;
        //define hashmap
        Map<Character, Integer> map = new HashMap<>();
        //define maxLen
        int maxLen = 0;
        //find the maxlen sunbstring of at least 2 distinct characters
        while(R < len){
            map.put(c[R], map.getOrDefault(c[R], 0) + 1);
            
            //shrink window if we don't mee the condition
            while(map.size() > 2){
                map.put(c[L], map.get(c[L]) - 1);
                if(map.get(c[L]) == 0){
                    map.remove(c[L]);
                }
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }
        return maxLen;
    }
}