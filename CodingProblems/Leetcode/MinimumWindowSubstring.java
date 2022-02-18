/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t 
(including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.isEmpty()) return "";
        //define table
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        
        //increment character count in map
        for(char c : t.toCharArray()){
            map[c]++;
        }
        
        //define pointers and counter
        int left = 0;
        int right = 0;
        int count = 0;
        
        //define minLen
        int minLen = Integer.MAX_VALUE;
        
        //define result
        String result = "";
        
        //find the minimum window
        while(right < arr.length){
            //get char for right
            map[arr[right]]--;
            //expand window from right end
            if(map[arr[right]] >= 0){
                count++;
            }
            //shrink window from left side
            while(count == t.length()){
                int curWindow = right - left + 1;
                if(curWindow < minLen){
                    minLen = curWindow;
                    result = s.substring(left, right + 1);
                }
                //get left char from left
                map[arr[left]]++;
                //shrink left
                if(map[arr[left]] > 0){
                    count--;
                }
                left++;
            }
            right++;
        }
        //return result
        return result;
    }
}