/*
This is an interactive problem.

You are given an array of unique strings wordlist where wordlist[i] is 6 letters long, and one word in this list is chosen as secret.

You may call Master.guess(word) to guess a word. The guessed word should have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact matches (value and position) of your guess to the secret word. 
Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have exactly 10 guesses to guess the word. At the end of any number of calls, if you have made 10 or fewer 
calls to Master.guess and at least one of these guesses was secret, then you pass the test case.

Example 1:

Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"], numguesses = 10
Output: You guessed the secret word correctly.
Explanation:
master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
We made 5 calls to master.guess and one of them was the secret, so we pass the test case.

Example 2:

Input: secret = "hamada", wordlist = ["hamada","khaled"], numguesses = 10
Output: You guessed the secret word correctly.
 

Constraints:

1 <= wordlist.length <= 100
wordlist[i].length == 6
wordlist[i] consist of lowercase English letters.
All the strings of wordlist are unique.
secret exists in wordlist.
numguesses == 10
*/
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        //1. add words to set
        //2. take one of the words, call guess
        //3. compare number to the others in set, if not equal then remove
        //4. helper function to count chars that are the same btwn guessed word and others
        List<String> ts = new ArrayList<>();
        for(String s : wordlist){
            ts.add(s);
        }
        while(!ts.isEmpty()){
            int idx = ts.size() / 2;
            String word = ts.get(idx);
            int valGuess = master.guess(word);
            if(valGuess == 6) return;
            ts.removeIf(val -> helper(word, val) != valGuess);
        }
    }
    //returns count of the same char in the same place for two strings
    public int helper(String s, String t){
        int value = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(i)){
                value += 1;
            }
        }
        return value;
    }
}
/*----------------------------------------------------------------------------------------*/
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    private final static int MAX_GUESS_CALLS = 10;
    
    public void findSecretWord(String[] wordlist, Master master) {
        Set<String> words = new HashSet<>();
        for(String word : wordlist) {
            words.add(word);
        }
        
        //basic case
        if(words.size() <= MAX_GUESS_CALLS) {
            words.forEach(master::guess);
            return;
        }
        
        for(int i = 0; i < MAX_GUESS_CALLS; i++) {
            String guessedWord = words.iterator().next();
            int matches = master.guess(guessedWord);
            if(matches == guessedWord.length()) return;
            
            reduceGuessBase(words, guessedWord, matches);
        }
    }
    
    private void reduceGuessBase(Set<String> words, String guessedWord, int matches) {
        Iterator<String> wordsIterator = words.iterator();
        while(wordsIterator.hasNext()) {
            String word = wordsIterator.next();
            int matchCount = 0;
            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == guessedWord.charAt(i)) matchCount++;
                if(matchCount > matches) break;
            }
            
            if(matchCount != matches) wordsIterator.remove();
        }
    }
}