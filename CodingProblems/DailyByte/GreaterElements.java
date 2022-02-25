/*
Given two arrays of numbers, where the first array is a subset of the second array, return an array containing 
all the next greater elements for each element in the first array, in the second array. If there is no 
greater element for any element, output -1 for that number.

Ex: Given the following arrays…

nums1 = [4,1,2], nums2 = [1,3,4,2], return [-1, 3, -1] because no element in nums2 is greater than 4, 3 is the first number in nums2 greater than 1, and no element in nums2 is greater than 2.
nums1 = [2,4], nums2 = [1,2,3,4], return [3, -1] because 3 is the first greater element that occurs in nums2 after 2 and no element is greater than 4.

*/
public int[] greaterElements(int[] nums1, int[] nums2) {
    Stack < Integer > stack = new Stack<>();
    HashMap < Integer, Integer > map = new HashMap <>();
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums2.length; i++) {
        while (!stack.empty() && nums2[i] > stack.peek()) {
            map.put(stack.pop(), nums2[i]);
        }
        stack.push(nums2[i]);
    }

    while (!stack.empty()) {
        map.put(stack.pop(), -1);
    }

    for (int i = 0; i < nums1.length; i++) {
        result[i] = map.get(nums1[i]);
    }

    return result;
}
/*
Big-O Analysis
Runtime: O(N + M) where N is the number of elements in nums1 and M is the number of elements in nums2.
Space complexity: O(N + M) where N is the size of our return array (which is the size of nums1) and M is 
the size of nums2 (due to using a hash map and stack).
*/