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
class Trie{
    Set<String> word;
    Set<String> pre;
    
    public Trie(){
        word = new HashSet<>();
        pre = new HashSet<>();
    }
    
    public void insert(String words){
        word.add(words);
        for(int i = 0; i <= words.length(); i++){
            pre.add(words.substring(0, i));
        }
    }
    
    public boolean startsWith(String prefix){
        return pre.contains(prefix);
    }
    
    public boolean seach(String words){
        return word.contains(words);
    }
}

class Solution {
    List<String> result = new ArrayList<>();
    Set<String> rep = new HashSet<>();
    Trie prefix = new Trie();
    char[][] globalBoard;
    public List<String> findWords(char[][] board, String[] words) {
        globalBoard = board;
        for(String word : words){
            prefix.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(prefix.startsWith(board[i][j] + "")){
                    findWordsDfs(i, j, "");
                }
            }
        }
        return result;
    }
    
    public void findWordsDfs(int row, int col, String store){
        if(row < 0 || row >= globalBoard.length || col < 0 || col >= globalBoard[0].length){
            return;
        }
        if(globalBoard[row][col] == 'A'){
            return;
        }
        if(!prefix.startsWith(store)){
            return;
        }
        store += globalBoard[row][col] + "";
        if(prefix.seach(store) && !rep.contains(store)){
            rep.add(store);
            result.add(store);
        }
        char temp = globalBoard[row][col];
        globalBoard[row][col] = 'A';
        findWordsDfs(row, col - 1, store);//left
        findWordsDfs(row, col + 1, store);//right
        findWordsDfs(row - 1, col, store);//up
        findWordsDfs(row + 1, col, store);//down
        globalBoard[row][col] = temp;
        store = store.substring(0, store.length() - 1);
    }
}