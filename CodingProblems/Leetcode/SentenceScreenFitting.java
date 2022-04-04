/*
Given a rows x cols screen and a sentence represented as a list of strings, return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged, and a word cannot be split into two lines. A single space must separate two consecutive 
words in a line.

Example 1:

Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.

Example 2:

Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.

Example 3:

Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
Output: 1
Explanation:
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.
 

Constraints:

1 <= sentence.length <= 100
1 <= sentence[i].length <= 10
sentence[i] consists of lowercase English letters.
1 <= rows, cols <= 2 * 10^4
*/
class Solution {
	//brute force: simulate but the problem is when the the rows and cols are over 1000 it can time out
    public int wordsTyping(String[] sentence, int rows, int cols) {
        //int ans, keep track of increment it if we reach the end of the array and it can fit
        int ans = 0;
        
        //int index, keeping track of where we are within given sentence array (reset it at end)
        int idx = 0;
        
        //int colsLeft in a row, (reset it at end of ta row)
        int colsLeft = cols;
        
        //while loop, while we have rows left and cols left in row
        while(rows > 0 && colsLeft >= 0){
            String word = sentence[idx];
            if(word.length() <= colsLeft){
                //update colsLeft
                colsLeft = colsLeft - word.length();
                idx += 1;
                //update to remove cols left one more, because space in between
                if(colsLeft > 0){
                    colsLeft -= 1;
                }
            }else{
                colsLeft = cols;
                rows -= 1;
            }
            if(idx == sentence.length){
                ans += 1;
                idx = 0;
            }
        }
        return ans;
    }
}
/*---------------------------------------------------------------------------------------------------------------*/
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb =  new StringBuilder();
        
        for(String word : sentence){
            sb.append(word + " ");
        }
        String sentenceStr = sb.toString();
        int sentenceLen = sentenceStr.length();
        
        int cursor = 0; //how much space we used to fit words withing the string
        for(int row = 0; row < rows; row++){
            //calculate
            cursor += cols;//space allocation
            if(sentenceStr.charAt(cursor % sentenceLen) == ' '){
                ++cursor;//fit word in the new line
            }else{
                while(cursor >= 0 && sentenceStr.charAt(cursor % sentenceLen) != ' '){
                    --cursor;
                }
                ++cursor;
            }
        }
        return cursor / sentenceLen;
    }
}