/*
You are given a group of stones, all of which have a positive weight. At each turn, we select the heaviest two stones and smash them together. 
When smashing these two stones together, one of two things can happen:

If the stones are both the same weight, both stones are destroyed
If the weights of the stones are not equal, the smaller of the two stones is destroyed and the remaining stone’s weight is updated to 
the difference (i.e. if we smash two stones together of weight 3 and weight 5 the stone with weight 3 is destroyed and the stone with 
original weight 5 now has weight 2).
Continue smashing stones together until there is at most one stone left and return the weight of the remaining stone. 
If not stones remain, return zero.

Ex: Given the following stones…

stones = [2, 4, 3, 8], return 1
8 and 4 are smashed together, 4 is destroyed, 8 becomes 4.
4 and 3 are smashed together, 3 is destroyed, 4 becomes 1.
2 and 1 are smashed together, 1 is destroyed, 2 becomes 1.
1 is the last stone remaining and is therefore returned.
Ex: Given the following stones…

stones = [1, 2, 3, 4], return 0
4 and 3 are smashed together, 3 is destroyed, 4 becomes 1.
2 and 1 are smashed together, 1 is destroyed, 2 becomes 1.
1 and 1 are smashed together and both stones are destroyed.
0 is returned as no stones remain.
*/
public int throwingStones(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    for (int stone: stones) {
        maxHeap.add(stone);
    }

    while (maxHeap.size() > 1) {
        int stone1 = maxHeap.remove();
        int stone2 = maxHeap.remove();
        if (stone1 != stone2) {
            maxHeap.add(Math.abs(stone1 - stone2));
        }
    }

    return maxHeap.isEmpty() ? 0 : maxHeap.remove();
}
/*
Big-O Analysis
Runtime: O(NlogN) where N is the total number of stones we are given. This results from removing N items from our heap where each of the 
N removals costs O(logN) time (i.e. the height of our heap).
Space complexity: O(N) where N is the total number of stones we are given. This results from storing N elements in our max heap.
*/