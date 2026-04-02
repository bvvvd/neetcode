class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] candidate = new int[]{0, 0, 0};
        for (int[] triplet: triplets) {
            if (target[0] >= triplet[0] && target[1] >= triplet[1] && target[2] >= triplet[2]) {
                candidate[0] = Math.max(candidate[0], triplet[0]);
                candidate[1] = Math.max(candidate[1], triplet[1]);
                candidate[2] = Math.max(candidate[2], triplet[2]);
            }
        }

        return candidate[0] == target[0] && candidate[1] == target[1] && candidate[2] == target[2];
    }
}
