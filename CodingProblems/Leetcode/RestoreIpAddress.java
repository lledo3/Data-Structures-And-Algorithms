/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and 
cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. 
You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

Constraints:

1 <= s.length <= 20
s consists of digits only.
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        //base case
        if(s == null || s.length() < 4 || s.length() > 12) return res;
        
        backTrackDfsRestoreIpAddress(s, "", 0, res);
        
        return res;
    }
    
    public void backTrackDfsRestoreIpAddress(String s, String sub, int idx, List<String> res){
        //base check to stop recursion
        if(idx == 4 || s.length() == 0){
            if(idx == 4 && s.length() == 0){
                res.add(sub.substring(0, sub.length() - 1));
            }
            return;
        }
        //case 1: choose 1 digit
        backTrackDfsRestoreIpAddress(s.substring(1), sub + s.substring(0, 1) + ".", idx + 1, res);
        //case 2: choose 2 digits
        if(s.length() > 1 && s.charAt(0) != '0'){
            backTrackDfsRestoreIpAddress(s.substring(2), sub + s.substring(0, 2) + ".", idx + 1, res);
            //case3: choose 3 digits
            if(s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255){
                backTrackDfsRestoreIpAddress(s.substring(3), sub + s.substring(0, 3) + ".", idx + 1, res);
            }
        }
    }
}

/*
1. valid IP address
- 4 parts
- max number of digits, each part, 3
- min number of digits, each part, 1
    1.1.1.1 or 1.11.111.1 -> valid ip address
- no number greater than 255, not valid
2. DFS backtracking
*/