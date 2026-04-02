class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> allNumbers = new HashSet<>();
        for (int num: nums) {
            allNumbers.add(num);
        }

        int longestSequence = 0;
        for (int num: nums) {
            if (!allNumbers.contains(num - 1)) {
                int sequenceLength = 0;

                int currentNumber = num;
                while (allNumbers.contains(currentNumber)) {
                    allNumbers.remove(currentNumber);
                    currentNumber++;
                    sequenceLength++;
                }

                longestSequence = Math.max(longestSequence, sequenceLength);
            }
        }

        return longestSequence;
    }
}
