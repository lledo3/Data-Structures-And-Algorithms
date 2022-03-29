/*
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 

Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false
 

Constraints:

-10^5 <= number <= 10^5
-2^31 <= value <= 2^31 - 1
At most 104 calls will be made to add and find.
*/
class TwoSum {
    private HashMap<Integer, Integer> numCnts;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.numCnts = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (this.numCnts.containsKey(number))
            this.numCnts.replace(number, this.numCnts.get(number) + 1);
        else
            this.numCnts.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
       for (Map.Entry<Integer, Integer> entry : this.numCnts.entrySet()) {
            int comp = value - entry.getKey();
            if (comp != entry.getKey()) {
                if (this.numCnts.containsKey(comp))
                    return true;
            } else {
                if (entry.getValue() > 1)
                    return true;
            }
        }
        return false; 
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */