class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] relations = new int[n][2];
        for (int[] relation: trust) {
            relations[relation[0] - 1][0]++;
            relations[relation[1] - 1][1]++;
        }

        for (int i = 0; i < n; i++) {
            if (relations[i][0] == 0 && relations[i][1] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}