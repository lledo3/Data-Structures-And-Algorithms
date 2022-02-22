/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.
*/
class Solution {
    public Integer memoCuts[][];
    public Boolean memoPalindrome [][];
    public int minCut(String s) {
        memoCuts = new Integer[s.length()][s.length()];
        memoPalindrome = new Boolean[s.length()][s.length()];
        return findMinimumCuts(s, 0, s.length() - 1, s.length() - 1);
    }
    
    public int findMinimumCuts(String s, int start, int end, int minimumCut){
        //base case
        if(start == end || isPalindrome(s, start, end)){
            return 0;
        }
        //check for results in memoCuts
        if(memoCuts[start][end] != null){
            return memoCuts[start][end];
        }
        for(int curIdx = start; curIdx <= end; curIdx++){
            if(isPalindrome(s, start, curIdx)){
                minimumCut = Math.min(minimumCut, 1 + findMinimumCuts(s, curIdx + 1, end, minimumCut));
            }
        }
        
        return memoCuts[start][end] = minimumCut;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        if(start >= end){
            return true;
        }
        //check for results in memPalindrome
        if(memoPalindrome[start][end] != null){
            return memoPalindrome[start][end];
        }
        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1);
    }
}