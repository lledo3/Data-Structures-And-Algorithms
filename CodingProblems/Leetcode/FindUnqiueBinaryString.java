/*
Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. 
If there are multiple answers, you may return any of them.

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.
*/
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            if(nums[i].charAt(i) == '1') st.append('0');
            else st.append('1');
        }
        return st.toString();   
    }
}


class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String result="";
        
        Set<String> givenNumbersSet = new HashSet();
        
        for(int i =0; i<nums.length; i++) {
            givenNumbersSet.add(nums[i]);
        }
        
        Set<String> allBinaryStrSet = new HashSet();
		
        generateBinaryStrings("", "", nums[0].length(), allBinaryStrSet, givenNumbersSet);
        
        return allBinaryStrSet.stream().findFirst().get();
    }
    
    // generate binary strings of length "l". if it finds a string of length "l" which is not
    // in given input strings, it add it to result set and returns.
    
    public void generateBinaryStrings(String s, String t, int l, Set<String> set, Set<String> givenNumbersSet) {
		
		if(s.length()>l) {
			return;
		}
		
		if(s.length()==l) {
			 if(!givenNumbersSet.contains(s)) {
                set.add(s);
                return;
            }
		}
		
		s= s+t;
		
		generateBinaryStrings(s, "1", l, set, givenNumbersSet);
		generateBinaryStrings(s, "0", l, set, givenNumbersSet);
	}
}