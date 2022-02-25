/*
Given two strings s and t return whether or not s is an anagram of t.
Note: An anagram is a word formed by reordering the letters of another word.

Ex: Given the following strings...

s = "cat", t = "tac", return true
s = "listen", t = "silent", return true
s = "program", t = "function", return false
*/
public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) {
        return false;
    }

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(char c: s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for(char c: t.toCharArray()) {
        if(!map.containsKey(c) || map.get(c) <= 0) {
            return false;
        } else {
            map.put(c, map.get(c) - 1);
        }
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(N) where N is the total number of characters in both s and t. 
This is because we will need to iterate through every character in each string to confirm whether or not s is an anagram of t in the worst case.
Space complexity: O(N) as we will create a hash map that will store all the characters in one of our strings
*/