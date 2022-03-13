/*
You're developing a new programming language with some unusual features for strings! Among these is a method that 
returns the longest palindrome that can be formed with the characters of a given string.

Given a string s, your task is to find this longest possible palindrome. You may use any number of the characters 
from s, and arrange them in any order (so long as it results in a palindrome).

If there are multiple longest palindromes that can be formed, return the one among them that's lexicographically smallest.

Example

For s = "aaabb", the output should be solution(s) = "ababa".

There are two possible palindromes of length 5 that can be obtained ("ababa" and "baaab"), but "ababa" is 
lexicographically smaller, thus it is the answer.

For s = "aaabbbcc", the output should be solution(s) = "abcacba".

It's not possible to form a palindrome of length 8, but from several palindromes of length 7, "abcacba" is the 
lexicographically smallest, thus it is the answer.
*/
String solution(String a) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i=0; i<a.length(); i++) {
        map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
    }
    char mid = 0;
    boolean mid_chosen = false;
    StringBuilder left = new StringBuilder();
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        if(!mid_chosen && entry.getValue() % 2 != 0) { //odd
            mid_chosen = true;
            mid = entry.getKey();
        }
        //Adding elements to left
        for(int k=0; k<entry.getValue()/2; k++) {
            left.append(entry.getKey());
        }
    }
    //New Step added to sort it lexicographically 
    char[] leftChArr = left.toString().toCharArray();
    Arrays.sort(leftChArr);
    
    StringBuilder leftC = new StringBuilder(new String(leftChArr));
    StringBuilder right = new StringBuilder();
    //adding reverse elements to left
    for(int j=leftC.length()-1; j>=0; j--) {
        right.append(leftC.charAt(j));
    }
    if(mid_chosen == true) {
        leftC.append(mid).append(right);
    } else {
        leftC.append(right);
    }
    return leftC.toString();      
}