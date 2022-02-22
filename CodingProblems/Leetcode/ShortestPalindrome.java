/*
You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"

Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 10^4
s consists of lowercase English letters only
*/
class Solution {
    public String shortestPalindrome(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        
        //use a special character to avoid overlap
        String l = s + "#" + revS;
        
        int[] p = new int[l.length()];
        
        //build KMP table
        //i -> sufffix boundary
        //j -> prefix boundary
        for(int i = 1; i < l.length(); i++){
            
            //update prefix boundary
            int j = p[i - 1];
            
            //move to the last prefix boundary match
            while(j > 0 && l.charAt(i) != l.charAt(j)){
                j = p[j - 1];
            }
            
            //if prefix boundary matches suffix boundary, increase prefix length
            if(l.charAt(i) == l.charAt(j)){
                p[i] = j + 1;
            }
        }
        return revS.substring(0, s.length() - p[l.length() - 1]) + s;
    }
}