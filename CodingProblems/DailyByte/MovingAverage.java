/*
Design a class, MovingAverage, which contains a method, next that is responsible for returning the moving average from a stream of integers.
Note: a moving average is the average of a subset of data at a given point in time.


// i.e. the moving average has a capacity of 3.
MovingAverage movingAverage = new MovingAverage(3);
m.next(3) returns 3 because (3 / 1) = 3
m.next(5) returns 4 because (3 + 5) / 2 = 4 
m.next(7) = returns 5 because (3 + 5 + 7) / 3 = 5
m.next(6) = returns 6 because (5 + 7 + 6) / 3 = 6
*/
public class MovingAverage {
    int[] stream;
    int size;
    int insert;
    int sum;

    public MovingAverage(int size) {
        stream = new int[size];
        size = 0;
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (size < stream.length) {
            size++;
        }

        sum -= stream[insert];
        sum += val;
        stream[insert++] = val;
        insert %= stream.length;

        return (double)sum / size;
    }
}
/*
Big-O Analysis
Runtime: O(1) as we can return the average of our stream of integers in constant time 
(i.e. we don't have to iterate through all N elements in our stream)
Space complexity: O(N) where N is the size of our stream
*/