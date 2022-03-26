/*
Releasing software can be tricky and sometimes we release new versions of our software with bugs. When we release a version with a 
bug it’s referred to as a bad release. Your product manager has just informed you that a bug you created was released in one of the 
past versions and has caused all versions that have been released since to also be bad. Given that your past releases are numbered 
from zero to N and you have a helper function isBadRelease(int releaseNumber) that takes a version number and returns a boolean as 
to whether or not the given release number is bad, return the release number that your bug was initially shipped in.
Note: You should minimize your number of calls made to isBadRelease().

Ex: Given the following value N…

N = 5 and release number four is the release your bug was shipped in...

isBadRelease(3) // returns false.
isBadRelease(5) // returns true.
isBadRelease(4) // returns true.

return 4.
*/
public int badReleases(int N) {
    int left = 0;
    int right = N;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(isBadRelease(mid)) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
/*
Big-O Analysis
Runtime: O(logN). This results from discarding half of our search space each time we call isBadRelease().
Space complexity: O(1) or constant since our memory usage does not scale as N does.
*/