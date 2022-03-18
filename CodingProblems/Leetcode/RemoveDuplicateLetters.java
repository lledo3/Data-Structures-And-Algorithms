/*
Given a string s, remove duplicate letters so that every letter appears once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"

Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 10^4
s consists of lowercase English letters.
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        //count array to count the appearance of each letter
        int[] count = new int[26];
        for (char c : chs) {
            count[c - 'a']++;
        }
        
        //boolean used array to mark whether we have used that letter before
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        //try to append lexicographically 
        for (char c : chs) {
            count[c - 'a']--;

            if (used[c - 'a']) continue;
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c
                && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append((char) c);
            used[c - 'a'] = true;
        }

        return sb.toString();
    }
}