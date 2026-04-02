class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        if (a > 0) {
            heap.add(new int[] {0, a});
        }
        if (b > 0) {
            heap.add(new int[] {1, b});
        }
        if (c > 0) {
            heap.add(new int[] {2, c});
        }

        StringBuilder builder = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] candidate = heap.poll();
            char cc = (char) (candidate[0] + 'a');
            int count = candidate[1];

            if (builder.isEmpty() 
                || builder.charAt(builder.length() - 1) != cc) {
                builder.append(cc);
                count--;
                if (count > 0) {
                    builder.append(cc);
                    count--;
                }
                if (count > 0) {
                    heap.add(new int[] {cc - 'a', count});
                }
            } else if (builder.length() == 1
                || builder.length() > 1 && builder.charAt(builder.length() - 2) != cc) {
                builder.append(cc);
                if (count > 1) {
                    heap.add(new int[] {cc - 'a', count - 1});
                }
            } else if (heap.isEmpty()) {
                return builder.toString();
            } else {
                int[] newCandidate = heap.poll();
                char newC = (char) (newCandidate[0] + 'a');
                int newCount = newCandidate[1];

                builder.append(newC);
                newCount--;
                if (newCount > 0) {
                    heap.add(new int[] {newC, newCount});
                }
                heap.add(candidate);
            }
        }
        return builder.toString();
    }
}