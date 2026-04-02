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

        PriorityQueue<Interval> overlapping = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        int rooms = 0;

        for (var interval: intervals) {
            while (!overlapping.isEmpty() && overlapping.peek().end <= interval.start) {
                overlapping.poll();
            }
            overlapping.add(interval);
            rooms = Math.max(rooms, overlapping.size());
        }

        return rooms;
    }
}
