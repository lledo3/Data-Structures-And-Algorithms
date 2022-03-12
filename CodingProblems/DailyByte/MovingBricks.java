/*
You are transporting bricks on a construction site and want to work as efficiently as possible. 
The weight of each brick is given by bricks[i]. Given a wheelbarrow that can carry up to (not including) 
5000 pounds, return then maximum number of bricks you can place in your wheelbarrow to transport.

Ex: Given the following bricks…

bricks = [1000, 1000, 1000, 2000], return 3.

Ex: Given the following bricks…

bricks = [1000, 200, 150, 200], return 4.
*/
public int movingBricks(int[] bricks) {
    Arrays.sort(bricks);
    int count = 0;
    int weight = 0;
    for (int i = 0; i < bricks.length; i++) {
        if (weight + bricks[i] < 5000) {
            count++;
            weight += bricks[i];
        } else {
            return count;
        }
    }

    return count;
}
/*
Big-O Analysis
Runtime: O(NlogN) where N is the total number of bricks we are given. This results from sorting our array.
Space complexity: O(1) or constant as the memory we use to solve our problem does not increase as our number of bricks increases.
*/