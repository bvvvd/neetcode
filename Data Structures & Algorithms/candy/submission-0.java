class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candiesF = new int[ratings.length];
        candiesF[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candiesF[i] = candiesF[i - 1] + 1;
            } else {
                candiesF[i] = 1;
            }
        }
        int[] candiesR = new int[ratings.length];
        candiesR[candiesR.length - 1] = 1;
        for (int i = candiesR.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candiesR[i] = candiesR[i + 1] + 1;
            } else {
                candiesR[i] = 1;
            }
        }

        System.out.println(Arrays.toString(candiesF));
        System.out.println(Arrays.toString(candiesR));

        int totalCandies = 0;
        for (int i = 0; i < ratings.length; i++) {
            totalCandies += Math.max(candiesR[i], candiesF[i]);
        }
        return totalCandies;
    }
}