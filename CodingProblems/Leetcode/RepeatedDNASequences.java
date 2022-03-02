/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. 
You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 10^5
s[i] is either 'A', 'C', 'G', or 'T'.
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() < 10) return new ArrayList<>();
        List<String> subseq = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= s.length() - 10; i++){
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        for(String seq : map.keySet()){
            if(map.get(seq) > 1){
                subseq.add(seq);
            }
        }
        return subseq;
    }
}