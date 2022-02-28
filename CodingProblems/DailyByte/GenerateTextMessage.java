/*
Backtracking
Given a string of digits, return all possible text messages those digits could send. 
Note: The mapping of digits to letters is as follows…

0 -> null
1 -> null
2 -> "abc"
3 -> "def"
4 -> "ghi"
5 -> "jkl"
6 -> "mno"
7 -> "pqrs"
8 -> "tuv"
9 -> "wxyz"

Ex: digits = "23" return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/
public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if(digits == null || digits.length() == 0) {
        return result;
    }

    String[] mappings = {
        "0",
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

    generateCombinations(0, "", mappings, digits, result);
    return result;
}

public void generateCombinations(int index, String current, String[] mappings, String digits, List<String> result) {
    if(index >= digits.length()) {
        result.add(current);
        return;
    }

    String letters = mappings[digits.charAt(index) - '0'];
    for(char c: letters.toCharArray()) {
        generateCombinations(index + 1, current + c, mappings, digits, result);
    }
}
/*
Big-O Analysis
Runtime: O(N^M) where N is the maximum number of characters any digit is allowed to map to and M is the number of digits we’re given 
in our string (this is because we have N choices, i.e. each letter in a mapping, for every digit in our string, i.e. M digits). 
Space complexity: O(M) where M is the number of digits we’re given in our string (due to our recursive calls on the stack).
*/