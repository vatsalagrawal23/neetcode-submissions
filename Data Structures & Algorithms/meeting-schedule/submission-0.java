/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
            intervals.sort(Comparator.comparingInt(a -> a.start));
            int n = intervals.size();
            if(n <= 1) {
                return true;
            }
            for(int i = 0; i < n -1; i++) {
                if(intervals.get(i).end > intervals.get(i+1).start) {
                    return false;
                }
            }
            
            return true;
        }
    }
