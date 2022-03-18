/*
Suppose I have "abbbccda" then it should return [1, 3]. Because it starts from index 1 and is 3 characters long. 
If the input string is empty then return [-1, 0].
Other Examples:
"10000111" => [ 1, 4 ]
"aabbbbbCdAA" => [ 2, 5 ]
*/
public int[] repeatedSubstring(String s){
        if(s.length() == 0) return new int[]{-1,0};
        if(s.length() == 1) return new int[]{0,1};
        int idx = -1;
        int maxCharCount = 0;
        int count = 1;
        int i;
        for(i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }else{
                if(count > maxCharCount){
                    maxCharCount = count;
                    idx = i - count;
                }
                count = 1;
            }
        }
        if(count > maxCharCount){
            maxCharCount = count;
            idx = i - count;
        }
       return new int[]{idx, maxCharCount};
 }