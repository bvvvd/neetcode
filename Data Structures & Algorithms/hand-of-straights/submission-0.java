class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cardFrequencies = new HashMap<>();
        for (int card: hand) {
            cardFrequencies.put(card, cardFrequencies.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);

        int groupCount = 0;
        for (int card: hand) {
            if (cardFrequencies.containsKey(card)) {
                for (int i = 0; i < groupSize; i++) {
                    Integer frequency = cardFrequencies.get(card + i);
                    if (frequency == null) {
                        return false;
                    } else if (frequency > 1) {
                        cardFrequencies.put(card + i, frequency - 1);
                    } else {
                        cardFrequencies.remove(card + i);
                    }
                }

                groupCount++;
                if (groupCount == hand.length / groupSize) {
                    return true;
                }
            }
        }

        return true;
    }
}
