/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a 
sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the 
shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        
        Set<String> wordSet = new HashSet<>();
        for(String word : wordList){
            wordSet.add(word);
        }
        if(!wordSet.contains(endWord)){
            return 0;
        }
        //bi-directional bfs
        return wordLadderBfs(beginSet, endSet, wordSet, 1);
    }
    
    public int wordLadderBfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int distance){
        //bi-directional bfs
        if(beginSet.size() > endSet.size()){
            return wordLadderBfs(endSet, beginSet, wordSet,distance);
        }
        Set<String> reachableSet = new HashSet<>();
        wordSet.removeAll(beginSet);
        
        for(String word : beginSet){
            for(int pos = 0; pos < word.length(); pos++){
                char[] charWordArray = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    charWordArray[pos] = c;
                    String newWord = new String(charWordArray);
                    if(wordSet.contains(newWord)){
                        if(endSet.contains(newWord)){
                            return distance + 1;
                        }
                        reachableSet.add(newWord);
                    }
                }
            }
        }
        distance++;
        if(reachableSet.isEmpty()){
            return 0;
        }
        return wordLadderBfs(reachableSet, endSet, wordSet, distance);
    }
}