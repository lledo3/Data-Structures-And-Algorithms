/*
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:

Input: num = "69"
Output: true

Example 2:

Input: num = "88"
Output: true

Example 3:

Input: num = "962"
Output: false
 

Constraints:

1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
*/
class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num.isEmpty()) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        
        for(int i = 0; i < num.length(); i++){
            char start = num.charAt(i);
            char end = num.charAt(num.length() - 1 - i);
            if(!map.containsKey(start) || map.get(start) != end){
                return false;
            }
        }
        if(num.length() % 2 == 1){
            char mid = num.charAt(num.length() / 2);
            if(mid == '0' || mid == '1' || mid == '8'){
                return true;
            }
            return false;
        }
        return true;
    }
}