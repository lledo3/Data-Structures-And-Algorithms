/*
We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

Example 1:

Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]

Example 2:

Input: strings = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strings.length <= 200
1 <= strings[i].length <= 50
strings[i] consists of lowercase English letters.
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        if(strings.length == 0) return res;
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strings){
            String p = pattern(s);
            if(!map.containsKey(p)){
                map.put(p, new LinkedList<>());
            }
            map.get(p).add(s);
        }
        for(String p : map.keySet()){
            res.add(map.get(p));
        }
        return res;
    }
    
    public String pattern(String s){
        if(s.length() == 0){
            return "";
        }    
        if(s.length() == 1){
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++){
            int diff = s.charAt(i + 1) - s.charAt(i);
            if(diff < 0){
                diff += 26;
            }
            sb.append(Integer.toString(diff) + ",");
        }
        return sb.toString();
    }
}