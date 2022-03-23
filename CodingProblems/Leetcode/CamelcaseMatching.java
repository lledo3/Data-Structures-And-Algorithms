/*
Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, 
and false otherwise.

A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert 
each character at any position and you may not insert any characters.

Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".

Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".

Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 

Constraints:

1 <= pattern.length, queries.length <= 100
1 <= queries[i].length <= 100
queries[i] and pattern consist of English letters.
*/
class Solution {
	//Number 1
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ret = new LinkedList<>();
        for (String query:queries) {
            ret.add(check(query, pattern));
        }

        return ret;
    }

    private Boolean check(String query, String pattern) {
        int patternLen = pattern.length(), patternPos = 0, uppercaseCount = 0;
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (Character.isUpperCase(c)) {
                if (patternPos < patternLen && c != pattern.charAt(patternPos)) {
                    return false;
                }
                uppercaseCount++;
                if (uppercaseCount > patternLen) {
                    return false;
                }
                patternPos++;
            } else {
                if (patternPos < patternLen && c == pattern.charAt(patternPos)) {
                    patternPos++;
                }
            }
        }

        return patternPos == patternLen;
    }
}

class Solution {
	//Number 2: Trie approach
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        TrieNode tn = new TrieNode();
        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            tn.addString(queries[i]);
        }
        HashSet<String> found = tn.searchForPattern(pattern);
        for(int i = 0; i < queries.length; i++){
            ans[i] = found.contains(queries[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(boolean a : ans){
            result.add(a);
        }
        return result;
    }
    public class TrieNode{
        TrieNode[] child;
        boolean wordEnd = false;

        public TrieNode(){
            child = new TrieNode[52];
            for(int i = 0; i < 32; i++){
                child[i] = null;
            }
        }

        public void addString(String s){
            TrieNode temp = this;
            for(int i = 0; i < s.length(); i++){
                int idx = getIndexForLetter(s.charAt(i));
                if(temp.child[idx] == null){
                    temp.child[idx] = new TrieNode();
                }
                temp = temp.child[idx];
            }
            temp.wordEnd = true;
        }

        public HashSet<String> searchForPattern(String pattern){
            HashSet<String> found = new HashSet<>();
            camelMatch(pattern, found, this,0,"");
            return found;
        }
        public void camelMatch(String pattern, HashSet<String> found, TrieNode root,int idx, String word){
            if(root == null) return;
            if(idx >= pattern.length()){
                if(root.wordEnd){
                    found.add(word);                
                }else{
                    for(int i = 0; i < 26; i++){
                        if(root.child[i] != null){
                            camelMatch(pattern, found, root.child[i], idx, word + getLetterForIndex(i));
                        }
                    }
                }
            }else{
                for(int i = 0; i < 52; i++){
                    if(pattern.charAt(idx) == getLetterForIndex(i)){
                        camelMatch(pattern, found, root.child[i], idx + 1, word + getLetterForIndex(i));
                    }else if(i < 26){
                        camelMatch(pattern, found, root.child[i], idx, word + getLetterForIndex(i));
                    }
                }
            }
        }
        public char getLetterForIndex(int i){
            if(i >= 26){
                return (char)(65 + i - 26);
            }else{
                return (char)(97 + i);
            }
        }
        public int getIndexForLetter(char c){
            if(Character.isUpperCase(c)){
                return 26 + (c - 'A');
            }else{
                return c - 'a';
            }
        }
    }
}