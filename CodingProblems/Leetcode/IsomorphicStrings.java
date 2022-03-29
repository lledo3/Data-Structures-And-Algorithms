/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ascii character.
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sToT = new char[256];
        char[] tToS = new char[256];
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sToT[sChar] == 0 && tToS[tChar] == 0){
                sToT[sChar] = tChar;
                tToS[tChar] = sChar;
            }else if(sToT[sChar] != tChar){
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hmap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(hmap.containsKey(s.charAt(i))){
                if(hmap.get(s.charAt(i)) != t.charAt(i) ) return false;
            }else if(hmap.containsValue(t.charAt(i))){
                return false;
            }else{
                hmap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}