/*
Given a list of strings dict where all the strings are of the same length.

Return true if there are 2 strings that only differ by 1 character in the same index, otherwise return false.

Example 1:

Input: dict = ["abcd","acbd", "aacd"]
Output: true
Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.

Example 2:

Input: dict = ["ab","cd","yz"]
Output: false

Example 3:

Input: dict = ["abcd","cccc","abyd","abab"]
Output: true
 

Constraints:

The number of characters in dict <= 10^5
dict[i].length == dict[j].length
dict[i] should be unique.
dict[i] contains only lowercase English letters.
 

Follow up: Could you solve this problem in O(n * m) where n is the length of dict and m is the length of each string.
*/
class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = null; //define just one string builder to save memory
        for (String d : dict) {
            sb = new StringBuilder(d);
            for (int i = 0; i < d.length(); i++) {
                char origin = sb.charAt(i);
                sb.setCharAt(i, '*');
                String candidate = sb.toString();
                if (!set.add(candidate)) return true;
                sb.setCharAt(i, origin);
            }
            sb.setLength(0);
        }
        return false;
    }
}
/*------------------------------------------------------------------------------------------------------------------------------*/
class Solution {
    class TrieNode{
        public TrieNode[] child;
        public boolean isWord = false;
        public char character;
        
        TrieNode(){
            child = new TrieNode[26];
        }
    }
    private TrieNode root;
    public boolean differByOne(String[] dict) {
        root = new TrieNode();
        for(String word : dict){
            if (search(word, root, 0, 0)){
                return true;
            }
            addWord(word);
        }
        return false;
    }
    
    private boolean search(String word, TrieNode root, int diffCnt, int index){
        
        if (diffCnt > 1) return false;
        if (index == word.length()) return root.isWord;
        TrieNode node = root;
        for(TrieNode n : node.child){
            if ( n != null){
                 if ( n.character == word.charAt(index) && search(word, n, diffCnt, index+1) ) return true;
                else if ( search(word, n, diffCnt+1, index+1) ) return true; 
            }
        }
        return false;
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if (node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
            node.character = ch;
        }
        node.isWord = true;
    }
}