/*
Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation 
of the two words words[i] + words[j] is a palindrome.

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters
*/
class Solution {
	//brute force - TC: O(n2*k) SC: O(n*k+n^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String combined = words[i].concat(words[j]);
                String reversed = new StringBuilder(combined).reverse().toString();
                if (combined.equals(reversed)) {
                    pairs.add(Arrays.asList(i, j));
                }
            }   
        }

        return pairs;
    }
}

class Solution {
	//optimal - TC: O(k^2*n) SC:O((k+n)^2)
    public List<List<Integer>> palindromePairs(String[] words) {
        // Build a word -> original index mapping for efficient lookup.
        Map<String, Integer> wordSet = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }

        // Make a list to put all the palindrome pairs we find in.
        List<List<Integer>> solution = new ArrayList<>();

        for (String word : wordSet.keySet()) {

            int currentWordIndex = wordSet.get(word);
            String reversedWord = new StringBuilder(word).reverse().toString();

            // Build solutions of case #1. This word will be word 1.
            if (wordSet.containsKey(reversedWord)
              && wordSet.get(reversedWord) != currentWordIndex) {
                solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedWord)));
            }

            // Build solutions of case #2. This word will be word 2.
            for (String suffix : allValidSuffixes(word)) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (wordSet.containsKey(reversedSuffix)) {
                    solution.add(Arrays.asList(wordSet.get(reversedSuffix), currentWordIndex));
                }
            }

            // Build solutions of case #3. This word will be word 1.
            for (String prefix : allValidPrefixes(word)) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (wordSet.containsKey(reversedPrefix)) {
                    solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedPrefix)));
                }
            }
        }
        return solution;
    }

    private List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, i, word.length() - 1)) {
                validPrefixes.add(word.substring(0, i));
            }
        }
        return validPrefixes;
    }

    private List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, 0, i)) {
                validSuffixes.add(word.substring(i + 1, word.length()));
            }
        }
        return validSuffixes;
    }

    // Is the prefix ending at i a palindrome?
    private boolean isPalindromeBetween(String word, int front, int back) {
        while (front < back) {
            if (word.charAt(front) != word.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }
}