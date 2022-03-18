/*
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 10^4
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
*/
class Solution {
	//TC: O(m + n) SC: O(words1.length)
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] alpha = new int[26];
        
        for(String word2 : words2){
            int[] tmp = new int[26];
            
            for(char c : word2.toCharArray()){
                tmp[c - 'a']++;
                alpha[c - 'a'] = Math.max(alpha[c - 'a'], tmp[c - 'a']);
            }
        }
        for(String word1 : words1){
            int[] arr = new int[26];
            for(char c : word1.toCharArray()){
                arr[c - 'a']++;
            }
            if(subset(arr, alpha)){
                res.add(word1);
            }
        }
        
        return res;
    }
    public boolean subset(int[] source, int[] dest){
        for(int i = 0; i < 26; i++){
            if(dest[i] > source[i]){
                return false;
            }
        }
        return true;
    }
}