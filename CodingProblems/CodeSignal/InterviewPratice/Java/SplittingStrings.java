/*
You are given a string s. Your task is to count the number of ways of splitting s into three non-empty parts a, b and c (s = a + b + c) 
in such a way that a + b, b + c and c + a are all different strings.

NOTE: + refers to string concatenation.

Example

For s = "xzxzx", the output should be solution(s) = 5.

Consider all the ways to split s into three non-empty parts:

If a = "x", b = "z" and c = "xzx", then all a + b = "xz", b + c = "zxzx" and c + a = xzxx are different.
If a = "x", b = "zx" and c = "zx", then all a + b = "xzx", b + c = "zxzx" and c + a = zxx are different.
If a = "x", b = "zxz" and c = "x", then all a + b = "xzxz", b + c = "zxzx" and c + a = xx are different.
If a = "xz", b = "x" and c = "zx", then a + b = b + c = "xzx". Hence, this split is not counted.
If a = "xz", b = "xz" and c = "x", then all a + b = "xzxz", b + c = "xzx" and c + a = xxz are different.
If a = "xzx", b = "z" and c = "x", then all a + b = "xzxz", b + c = "zx" and c + a = xxzx are different.
Since there are five valid ways to split s, the answer is 5.
*/
int solution(String s) {
    int len = s.length();
    int answer = 0;
    
    for(int i = 1; i < len - 1; i++){
        for(int j = i + 1; j < len; j++){
            String s1 = s.substring(0, i); 
            String s2 = s.substring(i, j);
            String s3 = s.substring(j, len);
            if(!(s1+s2).equals(s2+s3) && !(s2+s3).equals(s3+s1) && !(s1+s2).equals(s3+s1)){
                answer++;
            }
        }
    }
    return answer;
}