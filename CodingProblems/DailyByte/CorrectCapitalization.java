/*
Given a string, return whether or not it uses capitalization correctly. 
A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.

Ex: Given the following strings...

"USA", return true
"Calvin", return true
"compUter", return false
"coding", return true
*/
public boolean detectCapitalUse(String word) {
    int count = 0;
    for(int i = 0; i < word.length(); i++) {
        if(Character.isUpperCase(word.charAt(i))) {
            count++;
        }
    }

    return count == word.length() || count == 0 || count == 1 && Character.isUpperCase(word.charAt(0));
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in our word
Space complexity: O(1) or constant
*/