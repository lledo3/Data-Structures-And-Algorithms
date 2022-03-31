/*
Given a string s, return true if a permutation of the string could form a palindrome.

Example 1:

Input: s = "code"
Output: false

Example 2:

Input: s = "aab"
Output: true

Example 3:

Input: s = "carerac"
Output: true
 

Constraints:

1 <= s.length <= 5000
s consists of only lowercase English letters.
*/
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] counts = new int[128]; //ascii values
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i)]++;
        }
        int count = 0;
        for(int i = 0; i < 128; i++){
            count += counts[i] % 2;
        }
        return count <= 1;
    }
}
/*
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        for (char i = 0; i < 128 && count <= 1; i++) {
            int ct = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i)
                    ct++;
            }
            count += ct % 2;
        }
        return count <= 1;
    }
}
/*
*/
public class Solution {
 public boolean canPermutePalindrome(String s) {
     HashMap < Character, Integer > map = new HashMap < > ();
     for (int i = 0; i < s.length(); i++) {
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
     }
     int count = 0;
     for (char key: map.keySet()) {
         count += map.get(key) % 2;
     }
     return count <= 1;
 }
}
