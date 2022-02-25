/*
Given two strings s and t, which represents a sequence of keystrokes, where # denotes a backspace, 
return whether or not the sequences produce the same result.

Ex: Given the following strings...

s = "ABC#", t = "CD##AB", return true
s = "como#pur#ter", t = "computer", return true
s = "cof#dim#ng", t = "code", return false
*/
public boolean compareKeystrokes(String S, String T) {
    Stack<Character> sStack = new Stack<Character>();
    for(char c: S.toCharArray()) {
        if(c != '#') {
            sStack.push(c);
        } else if(!sStack.isEmpty()) {
            sStack.pop();
        }
    }

    Stack<Character> tStack = new Stack<Character>();
    for(char c: T.toCharArray()) {
        if(c != '#') {
            tStack.push(c);
        } else if(!tStack.isEmpty()) {
            tStack.pop();
        }
    }

    while(!sStack.isEmpty() && !tStack.isEmpty()) {
        if(sStack.pop() != tStack.pop()) {
            return false;
        }
    }

    return sStack.isEmpty() && tStack.isEmpty();
}
/*
Big-O Analysis
Runtime: O(N + M) where N is the number of characters in s and M is the number of characters in t. 
Space complexity: O(N + M) where N is the number of characters in s and M is the number of characters in t.
*/