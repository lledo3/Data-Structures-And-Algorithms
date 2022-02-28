/*
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
That is, each element of nums is covered by exactly one of the ranges, and 
there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 
 Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<String>();
        
        int i=0,n=nums.length;
        while(i<n)
        {
            int start,end;
            
            start=nums[i];            
            while(i+1<n && nums[i+1]==nums[i]+1) i++;
            end=nums[i];
            
            if(start==end)
                res.add(start + "");
            else
                res.add( start + "->" + end );
            
            i++;          
        }
        
        return res; 
    }
}
/*
Input nums = [0,2,3,4,6,8,9]
Output = ["0","2->4","6","8->9"]

Understanding :
The ranges are:
[0,0] –> “0”
[2,4] –> “2->4”
[6,6] –> “6”
[8,9] –> “8->9”

Algo
traverse for each adjacent elements. If difference between the two adjacent numbers is greater than 1 make a 
new range for the second number. Otherwise if the difference is exactly 1 then we will put that number in same range.

- Create a list of string to store the result.
- Start traversing the array from i=0 till i<N, (N is the size of array) in a while loop
- Traverse the array starting from current idx and find the last element whose difference from previous element is exactly 1, i.e. nums[i+1]==nums[i]+1
- Mark element as end range and insert into result list , repeat for remaining elements.
- Finally, return result list .
Time Compl-> 0(N)
Space -> 0(1)
*/