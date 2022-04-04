/*
There is a strange printer with the following two special properties:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.

Example 1:

Input: s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".

Example 2:

Input: s = "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 

Constraints:

1 <= s.length <= 100
s consists of lowercase English letters.
*/
class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int strangePrinter(String s) {
        return print(s);    
    }
    
    private int print(String str){
        if(str.length()==0){
            return 0;
        }
        if(str.length()==1){
            return 1;
        }
        if(map.containsKey(str)){
            return map.get(str);
        }
        char ch = str.charAt(0);
        int idx = 0;
        while(idx<str.length() && str.charAt(idx)==ch){
            idx++;
        }
        int best = 1+print(str.substring(idx));
        for(int i=idx;i<str.length();i++){
            if(str.charAt(i)==ch){
                best = Math.min(best,print(str.substring(idx,i))+print(str.substring(i)));
            }
        }
        map.put(str,best);
        return best;
    }
}