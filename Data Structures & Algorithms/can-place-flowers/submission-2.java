class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int bed = flowerbed[0] == 0 ? 1 : 0;
        for (int pot: flowerbed) {
            if (pot == 1) {
                n -= (bed - 1) / 2;
                bed = 0;
            } else {
                bed++;
            }
        }
        n -= bed / 2;

        return n <= 0;
    }
}