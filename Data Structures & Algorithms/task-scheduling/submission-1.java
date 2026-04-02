class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];
        for (char task: tasks) {
            taskFrequencies[task - 'A']++;
        }

        Arrays.sort(taskFrequencies);
        int maxFrequency = taskFrequencies[25];
        int idleTime = (maxFrequency - 1) * n;
        for (int i = 0; i < 25; i++) {
            idleTime -= Math.min(taskFrequencies[i], maxFrequency - 1);
        }
        return Math.max(0, idleTime) + tasks.length;
    }
}
