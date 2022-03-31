/*
Given a string s, return all the palindromic permutations (without duplicates) of it.

You may return the answer in any order. If s has no palindromic permutation, return an empty list.

Example 1:

Input: s = "aabb"
Output: ["abba","baab"]

Example 2:

Input: s = "abc"
Output: []
 

Constraints:

1 <= s.length <= 16
s consists of only lowercase English letters.
*/
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[256]; //ascii code
        int odd = 0;
        for(char c : s.toCharArray()){
            map[c]++;
            if(map[c] % 2 == 1){
                odd += 1;
            }else{
                odd -= 1;
            }
        }
        if(s.length() == 0 || odd > 1){
            return res;
        }
        String tmp = "";
        for(int i = 0; i < 256 && odd > 0; i++){
            if(map[i] % 2 == 1){
                tmp += (char) i;
                map[i]--;
                break;
            }
        }
        helper(res, tmp, map, s.length());
        return res;
    }
    public void helper(List<String> res, String tmp, int[] map, int n){
        if (tmp.length() == n) {
            res.add(tmp);
            return;
        }
        
        for (int i = 0; i < 256; i++) {
            if (map[i] > 0) {
                map[i] -= 2;
                helper(res, (char) i + tmp + (char) i, map, n);
                map[i] += 2;
            }
        }
    }
}
/*
*/
public class Solution {
    Set < String > set = new HashSet < > ();
    public List < String > generatePalindromes(String s) {
        permute(s.toCharArray(), 0);
        return new ArrayList < String > (set);
    }
    public boolean isPalindrome(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[s.length - 1 - i])
                return false;
        }
        return true;
    }
    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    void permute(char[] s, int l) {
        if (l == s.length) {
            if (isPalindrome(s))
                set.add(new String(s));
        } else {
            for (int i = l; i < s.length; i++) {
                swap(s, l, i);
                permute(s, l + 1);
                swap(s, l, i);
            }
        }
    }
}