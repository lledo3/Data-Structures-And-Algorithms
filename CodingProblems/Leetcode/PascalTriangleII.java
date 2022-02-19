/*
Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:

Input: rowIndex = 0
Output: [1]

Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        List<Integer> res = new ArrayList<>(prev);
        
        for(int i = 1; i <= rowIndex; i++){
            res.clear();
            res.add(1);
            for(int j = 0; j < prev.size() - 1; j++){
                res.add(prev.get(j) + prev.get(j + 1));
            }
            res.add(1);
            prev = new ArrayList(res);
        }
       return res; 
    }
}