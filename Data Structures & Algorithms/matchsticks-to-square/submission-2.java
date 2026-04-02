class Solution {
    private long side;
    private int[] sticks;

    public boolean makesquare(int[] matchsticks) {
        long sum = 0L;
        sticks = matchsticks;
        for (int stick: sticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        side = sum / 4;
        Arrays.sort(sticks);
        if (sticks[sticks.length - 1] > side) {
            return false;
        }

        return backtrack(0, new int[4]);
    }

    private boolean backtrack(int index, int[] sides) {
        if (index == sticks.length) {
            return sides[0] == side
                && sides[1] == side
                && sides[2] == side
                && sides[3] == side;
        }

        int stick = sticks[index];
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + stick <= side) {
                sides[i] += stick;
                if (backtrack(index + 1, sides)) {
                    return true;
                }
                sides[i] -= stick;
            }
        }

        return false;
    }
}