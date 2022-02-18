/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"

Example 3:

Input: n = 3, k = 1
Output: "123"

Constraints:

1 <= n <= 9
1 <= k <= n!
*/
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1; //factorial number
        
        for(int i = 1; i <= n; i++){
            fact *= i;
            nums.add(i);
        }
        k--;
        for(int i = 0; i < n; i++){
            fact /= (n - i);
            int idx = (k / fact);
            sb.append(nums.remove(idx));
            k %= fact;
        }
        return sb.toString();
    }
}