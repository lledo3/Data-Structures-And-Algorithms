/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPt = s.length() - 1;
        int tPt = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        
        while(sPt >= 0 || tPt >= 0){
            
            while(sPt >= 0){
                if(s.charAt(sPt) == '#'){
                    sSkip += 1;
                    sPt -= 1;
                }else if(sSkip > 0){
                    sPt -= 1;
                    sSkip -= 1;
                }else{
                    break;
                }
            }
            while(tPt >= 0){
                if(t.charAt(tPt) == '#'){
                    tSkip += 1;
                    tPt -= 1;
                }else if(tSkip > 0){
                    tPt -= 1;
                    tSkip -= 1;
                }else{
                    break;
                }
            }
            if(sPt >= 0 && tPt >= 0 && s.charAt(sPt) != t.charAt(tPt)){
                return false;
            }
            
            if((sPt >= 0) != (tPt >= 0)){
                return false;
            } 
            sPt -= 1;
            tPt -= 1;
        }
        return true;
    }
}