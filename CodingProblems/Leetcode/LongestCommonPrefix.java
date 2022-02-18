/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/
class Solution {
	//TC: O(n^2)
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0 || strs == null) {
	        return "";
	    }

	    for (int prefixLen = 0; prefixLen < strs[0].length(); prefixLen++) {
	        char c = strs[0].charAt(prefixLen);
	        for (int i = 1; i < strs.length; i++) {
	            if ( prefixLen >= strs[i].length() ||
	                 strs[i].charAt(prefixLen) != c ) {
	                return strs[i].substring(0, prefixLen);
	            }
	        }
	    }
	    return strs[0];
    }
    //TC: O(n)
     public String longestCommonPrefix2(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
        }        
    	return prefix;
	}
}