/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/
class Solution {
	//greedy approach
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return null;
        List<Integer> result = new ArrayList<>();
        int[] indices = new int[26];
        for(int i = 0; i < s.length(); i++){
            indices[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, indices[s.charAt(i) - 'a']);
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        char [] arr = s.toCharArray();
        int[] cache = new int[128];
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            cache[c] = i;
        }
        int L = 0, R = 0, idx = 0;
        List<Integer> result = new ArrayList<>();
        while(idx < arr.length){
            char c = arr[idx];
            R = Math.max(R, cache[c]);
            if(R == idx){
                int size = R - L + 1;
                result.add(size);
                R++;
                L = R;
            }
            idx++;
        }
        return result;
    }
}