/*
Given an array of strings, return the longest common prefix that is shared amongst all strings.
Note: you may assume all strings only contain lowercase alphabetical characters.

Ex: Given the following arrays...

["colorado", "color", "cold"], return "col"
["a", "b", "c"], return ""
["spot", "spotty", "spotted"], return "spot"
*/
public String longestCommonPrefix(String[] strs) {
    StringBuilder longestCommonPrefix = new StringBuilder();
    int index = 0;
    for(char c: strs[0].toCharArray()) {
        for(int i = 1; i < strs.length; i++) {
            if(index >= strs[i].length() || c != strs[i].charAt(index)) {
                return longestCommonPrefix.toString();
            }
        }

        longestCommonPrefix.append(c);
        index++;
    }

    return longestCommonPrefix.toString();
}
/*
Big-O Analysis
Runtime: O(N*M) where N is the number of words we’re given and M is the max number of characters a single string can contain. 
This runtime is derived from the fact that the worst case we will traverse every word and every character in every word. 
Space complexity: O(M) where M is the max number of characters a string can contain. 
This is because the longest our prefix can become is M characters long.
*/