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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> meetingEnds = new PriorityQueue<>();
        int maxRooms = 0;
        for (Interval interval: intervals) {
            while (!meetingEnds.isEmpty() && meetingEnds.peek() <= interval.start) {
                meetingEnds.poll();
            }
            meetingEnds.add(interval.end);

            maxRooms = Math.max(maxRooms, meetingEnds.size());
        }

        return maxRooms;
    }
}
