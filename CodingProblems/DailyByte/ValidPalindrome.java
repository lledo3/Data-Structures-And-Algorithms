/*
Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"level", return true
"algorithm", return false
"A man, a plan, a canal: Panama.", return true
*/
public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while(i < j) {
        while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
            i++;
        }
        while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
            j--;
        }

        if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
            return false;
        }
    }

    return true;
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in the given string because we only traverse the string once 
(even though there are nested loops - don’t be fooled!).
Space complexity: O(1) or constant as we only need couple variables to solve the problem (regardless of the size of the string)
*/