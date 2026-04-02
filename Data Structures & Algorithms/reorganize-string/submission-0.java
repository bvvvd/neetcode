class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c: s.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Entry> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        StringBuilder builder = new StringBuilder();
        for (var entry: charFrequencies.entrySet()) {
            heap.add(new Entry(entry.getKey(), entry.getValue()));
        }
        while (!heap.isEmpty()) {
            Entry candidate = heap.poll();
            if (builder.isEmpty() || builder.charAt(builder.length() - 1) != candidate.c) {
                builder.append(candidate.c);
                if (candidate.count > 1) {
                    heap.add(new Entry(candidate.c, candidate.count - 1));
                }
            } else if (heap.isEmpty()) {
                return "";
            } else {
                Entry newCandidate = heap.poll();
                builder.append(newCandidate.c);
                if (newCandidate.count > 1) {
                    heap.add(new Entry(newCandidate.c, newCandidate.count - 1));
                }
                heap.add(candidate);
            }
        }
        return builder.toString();
    }

    private record Entry(char c, int count) {}
}