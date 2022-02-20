/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 10^4
s and p consist of lowercase English letters.
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if(sLen < 1 || sLen < pLen) return res;
        int count = 0;
        
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        
        //build reference hashmap using string
        for(char c : p.toCharArray()){
            if(pCount.containsKey(c)){
                pCount.put(c, pCount.get(c) + 1);
            }else{
                pCount.put(c, 1);
            }
        }
        
        //sliding window on the string s
        for(int i = 0; i < sLen; i++){
            // add one more letter
            // on the right side of the window
            char c = s.charAt(i);
            if(sCount.containsKey(c)){
                sCount.put(c, sCount.get(c) + 1);
            }else{
                sCount.put(c, 1);
            }
            // remove one letter
            // from the left side of the window
            if(i >= pLen){
                c = s.charAt(i - pLen);
                if(sCount.get(c) == 1){
                    sCount.remove(c);
                }else{
                    sCount.put(c, sCount.get(c) - 1);
                }
            }
            // compare hashmap in the sliding window
            // with the reference hashmap
            if(pCount.equals(sCount)){
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}