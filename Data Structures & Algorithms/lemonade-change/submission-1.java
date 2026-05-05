class Solution {
    public boolean lemonadeChange(int[] bills) {
        int tens = 0;
        int fives = 0;
        for (int bill: bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives == 0) {
                    return false;
                } else {
                    fives--;
                    tens++;
                }
            } else {
                if (tens == 0 && fives < 3 || tens > 0 && fives == 0) {
                    return false;
                }
                if (tens == 0) {
                    fives -= 3;
                } else {
                    tens--;
                    fives--;
                }
            }
        }

        return true;
    }
}