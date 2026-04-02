class Solution {
    private int[] positions;
    private Map<Integer, Integer> carSpeed;
    private int destination;

    public int carFleet(int target, int[] position, int[] speed) {
        destination = target;
        positions = position;
        carSpeed = new HashMap<>();

        for (int i = 0; i < positions.length; i++) {
            carSpeed.put(positions[i], speed[i]);
        }
        Arrays.sort(positions);

        double arrivalTime = getArrivalTime(positions.length - 1);
        Map<Double, Integer> fleetArrivalTimes = new HashMap<>();
        fleetArrivalTimes.put(arrivalTime, 1);
        for (int i = position.length - 2; i >= 0; i--) {
            arrivalTime = Math.max(getArrivalTime(i), arrivalTime);
            fleetArrivalTimes.put(arrivalTime, fleetArrivalTimes.getOrDefault(arrivalTime, 0) + 1);
        }

        return fleetArrivalTimes.size();
    }

    private double getArrivalTime(int i) {
        return (destination - positions[i]) / (double) carSpeed.get(positions[i]);
    }
}
