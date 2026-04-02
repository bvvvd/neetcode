class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> contestants = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            contestants.add(stone);
        }

        while (contestants.size() > 1) {
            int hit = Math.abs(contestants.poll() - contestants.poll());

            if (hit != 0) {
                contestants.add(hit);
            }
        }

        return contestants.isEmpty() ? 0 : contestants.poll();
    }
}
