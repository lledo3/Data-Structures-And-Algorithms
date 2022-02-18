/*
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
    }
    
        Map<String, Integer> frequencyMap = new HashMap<>();
    
        for(String word: words) {
          frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
    
        int eachWordLength = words[0].length();
        int totalWords = words.length;
        List<Integer> result = new ArrayList<>();
    
        for (int i = 0; i <= s.length() - totalWords * eachWordLength; i++) {

          Map<String, Integer> seenWords = new HashMap<>();

          for (int j = 0; j < totalWords; j++) {
            int wordIndex = i + j * eachWordLength;

            String word = s.substring(wordIndex, wordIndex + eachWordLength);

            if(!frequencyMap.containsKey(word)) {
              break;
            }

            seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

            if(seenWords.get(word) > frequencyMap.getOrDefault(word, 0)) {
              break;
            }

            if(j + 1 == totalWords)   {
              result.add(i);
            }
          }
        }
    return result;
    }
}