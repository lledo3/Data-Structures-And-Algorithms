/*
Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"abcba", return true
"foobof", return true (remove the first 'o', the second 'o', or 'b')
"abccab", return false
*/
public boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while(i < j) {
        if(s.charAt(i) != s.charAt(j)) {
            return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }

        i++;
        j--;
    }

    return true;
}

public boolean isPalindrome(String s, int i, int j) {
    while(i < j) {
        if(s.charAt(i++) != s.charAt(j--)) {
            return false;
        }
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in our string
Space complexity: O(1) or constant
*/