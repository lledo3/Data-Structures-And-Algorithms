/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) 
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
*/
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        
        HashMap<String, Boolean> map = new HashMap();
        
        for(String word : words){
            //check word is subsequence of s,
            //and then save the result in map,
            
            if(!map.containsKey(word))
                map.put(word, isSubsequence(s, word));
            
            //increment the count
            if(map.get(word)) count++;
        }
        
        return count;
    }
    
    
    public boolean isSubsequence(String str1, String str2){
        int len1 = str1.length(); // length of string s
        int len2 = str2.length(); // length of string word
        
        if(len2 > len1) return false;
        
        int i1 = 0;
        int i2 = 0;
        
        while(i1 < len1 && i2 < len2){
            //charcater is matching increment both pointer
            if(str1.charAt(i1) == str2.charAt(i2)){
                i1++;
                i2++;
            } else {
                //character is not matching, just increase the pointer string s
                i1++;
            }
            
        }
		
		//check all character of current word is found in string s in same order
        return i2 == len2;
    }
}