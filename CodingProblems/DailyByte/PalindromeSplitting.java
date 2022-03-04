/*
Given a string s, return all possible partitions of s such that each substring is a palindrome.

Ex: Given the following string s…

s = "abcba",
return [
    ["a","b","c","b","a"],
    ["a","bcb","a"],
    ["abcba"]
]
*/
public List<List<String>> partition(String s) {
    List<List<String>> palindromes = new ArrayList<>();
    findPalindromes(s, new ArrayList<>(), palindromes, 0);

    return palindromes;
}

public void findPalindromes(String s, List<String> current, List<List<String>> palindromes, int start) {
    if (start == s.length()) {
        palindromes.add(new ArrayList<>(current));
        return;
    }

    for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
            current.add(s.substring(start, i + 1));
            findPalindromes(s, current, palindromes, i + 1);
            current.remove(current.size() - 1);
        }
    }
}

public boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
        if (s.charAt(i++) != s.charAt(j--)) {
            return false;
        }
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(N * 2N) where N is the number of characters in s. This results from having 2 choices at each of our N positions 
(i.e. split the string at the current position, or don’t split the string at the current position) and for each of these positions, 
we do a linear scan of the string to determine whether or not it is a palindrome.
Space complexity: O(N) where N is the number of characters in s. This results from N recursive calls on our stack.
*/