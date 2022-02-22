/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase English letters.
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //define table ascii characters
        int[] arr = new int[128];
        
        //define pointers
        int L = 0, R = 0;
        
        //fill up table
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        
        for(char cur : s1Arr){
            arr[cur]++;
        }
        
        //define minLen
        int minLen = Integer.MAX_VALUE;
        
        //define counter
        int counter = 0;
        
        //check if there is a permutation
        while(R < s2Arr.length){
            //expand window
            char cur = s2Arr[R];
            if(--arr[cur] >= 0){
                counter++;
            }
            
            //contract window
            while(counter == s1.length()){
                int curLen = R - L + 1;
                minLen = Math.min(curLen, minLen);
                char leftChar = s2Arr[L];
                if(++arr[leftChar] > 0){
                    counter--;
                }
                L++;
            }
            R++;
        }
        //return if minLen == size of s1
        return minLen == s1.length();
    }
}