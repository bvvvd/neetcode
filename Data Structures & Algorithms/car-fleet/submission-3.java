class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
        Stack<Double> fleetEtas = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            int[] car = cars[i];

            double eta = (target - car[0]) / (double) car[1];
            if (fleetEtas.isEmpty() || fleetEtas.peek() < eta) {
                fleetEtas.push(eta);
            }
        }

        return fleetEtas.size();
    }
}
