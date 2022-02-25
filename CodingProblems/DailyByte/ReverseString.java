/*
Given a string, reverse all of its characters and return the resulting string.

Ex: Given the following strings...

“Cat”, return “taC”
“The Daily Byte”, return "etyB yliaD ehT”
“civic”, return “civic”
*/
/*
While this solution works, it’s not very performant due to strings being immutable in Java 
(immutable is just a scary word that means cannot be changed). Because strings are immutable, 
every time we add a new character to the string an entirely new copy of that string is made containing the new character.
*/
public String reverse(String s) {
    String reversed = "";
    for (int i = s.length() - 1; i >= 0; i--) {
        reversed += s.charAt(i);
    }

    return reversed;
}

public String reverse(String s) {
    char[] characters = new char[s.length()];
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        characters[j++] = s.charAt(i);
    }

    return new String(characters);
}
/*
Big-O Analysis
Runtime: O(N) where N is the number of characters in our string s (because we only have to scan the string once to reverse it)
Space complexity: O(N) as well (because we must create a new string with N characters in it to solve the problem).
*/