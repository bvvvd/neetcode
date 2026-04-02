class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> activeMeetings 
            = new PriorityQueue<>((a, b) -> {
                int compare = Integer.compare(a[1], b[1]);

                return compare == 0 ? Integer.compare(a[0], b[0]) : compare;
            });
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }
        Map<Integer, Integer> roomFrequency = new HashMap<>();
        for (int[] meeting: meetings) {
            while (!activeMeetings.isEmpty() && activeMeetings.peek()[1] <= meeting[0]) {
                freeRooms.add(activeMeetings.poll()[0]);
            }

            int bookedRoom;
            if (freeRooms.isEmpty()) {
                int[] endedMeeting = activeMeetings.poll();
                bookedRoom = endedMeeting[0];
                activeMeetings.add(new int[] {bookedRoom, endedMeeting[1] + meeting[1] - meeting[0]});
            } else {
                bookedRoom = freeRooms.poll();
                activeMeetings.add(new int[] {bookedRoom, meeting[1]});
            }

            roomFrequency.put(bookedRoom, roomFrequency.getOrDefault(bookedRoom, 0) + 1);
        }

        int maxFrequency = 0;
        int theRoom = -1;
        for (int i = 0; i < n; i++) {
            int frequency = roomFrequency.getOrDefault(i, 0);
            if (frequency > maxFrequency) {
                theRoom = i;
                maxFrequency = frequency;
            }
        }
        return theRoom;
    }
}