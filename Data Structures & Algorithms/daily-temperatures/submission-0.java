class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexes = new Stack<>();
        int[] temperatureDistances = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!indexes.isEmpty() && temperatures[indexes.peek()] <= temperatures[i]) {
                indexes.pop();
            }

            temperatureDistances[i] = indexes.isEmpty() ? 0 : indexes.peek() - i;

            indexes.push(i);
        }

        return temperatureDistances;
    }
}
