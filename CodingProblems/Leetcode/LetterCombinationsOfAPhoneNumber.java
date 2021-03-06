/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 
Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList();
        if(digits.length() == 0) return res;
        String[] map = {"0",
                        "1",
                        "abc",
                        "def",
                        "ghi",
                        "jkl",
                        "mno",
                        "pqrs",
                        "tuv",
                        "wxyz"
                        };
        res.add("");
        
        for(int i = 0; i < digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i){
                String perm = res.remove();
                for(char c : map[index].toCharArray()){
                    res.add(perm + c);
                }
            }
        }
        return res;
    }
}