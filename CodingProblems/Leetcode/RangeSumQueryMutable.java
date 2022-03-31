/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 

Constraints:

1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 10^4 calls will be made to update and sumRange.
*/
class NumArray {
    int[] tree;
    int[] nums;
    int size;
    public NumArray(int[] nums) {
        this.size = nums.length;
        this.tree = new int[size + 1];
        this.nums = new int[size];
        this.nums = nums;
        
        for(int i = 0; i < size; i++){
            updateTree(i, nums[i]);
        }
    }
    
    public void updateTree(int i, int val){
        i = i + 1;
        while(i <= size){
            tree[i] += val;
            i += i & (-i);
        }
    }
    
    public void update(int index, int val) {
        updateTree(index, val - nums[index]);
        nums[index] = val;
    }
    
    public int getSum(int i){
        int sum = 0;
        i = i + 1;
        while(i > 0){
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return getSum(right);
        return getSum(right) - getSum(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */