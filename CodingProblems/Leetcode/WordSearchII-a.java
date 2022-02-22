/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent 
cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
class Solution {
    class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }
    TrieNode trie = new TrieNode();
    List<String> res = new LinkedList<>();
    int m, n;
    char[][] board;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        //Insert words onto the trie
        for(String word : words){
            insertAWord(word);
        }
        //For each character in board contains in trie, we dfs
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                char curChar = board[row][col];
                visited = new boolean[m][n];
                dfs(row, col, new StringBuilder(), trie);
            }
        }
        return res;
    }
    private void dfs(int row, int col, StringBuilder sb, TrieNode curTrie){
        //Base case
        if(row < 0 || row == m || col == n || col < 0) return;
        //Check if visited
        if(visited[row][col]) return;
        //Check if current character is in the trie
        char curChar = board[row][col];
        if(!curTrie.map.containsKey(curChar)) return;
        sb.append(curChar);
        curTrie = curTrie.map.get(curChar);
        visited[row][col] = true;
        //Add current string to the res if it is a word
        if(curTrie.isWord){
            res.add(sb.toString());
            curTrie.isWord = false;
        }
        
        //DFS all 4 directions
        dfs(row, col + 1, sb, curTrie);//right
        dfs(row + 1, col, sb, curTrie);//Down
        dfs(row - 1, col, sb, curTrie);//Up
        dfs(row, col - 1, sb, curTrie);//left
        //Remove last element: Backtracking
        sb.setLength(sb.length() - 1);
        visited[row][col] = false;
    }
    private void insertAWord(String word){
        char[] arr = word.toCharArray();
        TrieNode curNode = trie;
        for(char curChar : arr){
            if(!curNode.map.containsKey(curChar)){
                curNode.map.put(curChar, new TrieNode());
            }
            curNode = curNode.map.get(curChar);
        }
        curNode.isWord = true;
    }
}