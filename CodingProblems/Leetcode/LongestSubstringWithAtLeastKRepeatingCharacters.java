/*
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of 
each character in this substring is greater than or equal to k.

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 10^4
s consists of only lowercase English letters.
1 <= k <= 10^5
*/
class Solution {
	//divide and conquer
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    public int helper(char[] c, int start, int end, int k){
        if(end - start < k) return 0;
        
        int[] count = new int[26];
        for(int i = start; i < end; i++){
            count[c[i] - 'a']++;
        }
        for(int i = start; i < end; i++){
            if(count[c[i] - 'a'] < k){
                int j = i + 1;
                
                while(j < end && count[c[j] - 'a'] < k){
                    j++;
                }
                return Math.max(helper(c, start, i, k), helper(c, j, end, k));
            }
        }
        return end - start;
    }
}

class Solution {
	//brute force
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }
        int[] countMap = new int[26];
        int n = s.length();
        int result = 0;
        for (int start = 0; start < n; start++) {
            // reset the count map
            Arrays.fill(countMap, 0);
            for (int end = start; end < n; end++) {
                countMap[s.charAt(end) - 'a']++;
                if (isValid(s, start, end, k, countMap)) {
                    result = Math.max(result, end - start + 1);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s, int start, int end, int k, int[] countMap) {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap) {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}