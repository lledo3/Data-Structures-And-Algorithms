/*
Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
 

Constraints:

2 <= timePoints.length <= 2 * 10^4
timePoints[i] is in the format "HH:MM".
*/
class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seen = new boolean[24 * 60]; //1440 different time point
        
        for(String time : timePoints){
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int min = Integer.parseInt(timeSplit[1]);
            if(seen[(hour * 60) + min]){
                return 0;
            }
            seen[(hour * 60) + min] = true;
        }
        Integer firstTimeSeen = null;
        Integer prevTimeSeen = null;
        Integer minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < 1440; i++){
            if(seen[i]){
                if(firstTimeSeen == null){
                    firstTimeSeen = i;
                    prevTimeSeen = i;
                }else{
                    minDiff = Math.min(minDiff, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
                    prevTimeSeen = i;
                }
            }
        }
        minDiff = Math.min(minDiff, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));
        return minDiff;
    }
}