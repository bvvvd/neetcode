class Solution {
    private Set<String> dictionary;
    private Set<String> seen;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        int steps = 1;
        Queue<String> queue = new LinkedList<>();
        seen = new HashSet<>();
        seen.add(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                for (String transformation: transform(word)) {
                    seen.add(transformation);
                    queue.add(transformation);
                }
            }
            steps++;
        }

        return 0;
    }

    private List<String> transform(String word) {
        char[] chars = word.toCharArray();
        List<String> transformations = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                if (newChar != oldChar) {
                    chars[i] = newChar;
                    String transformation = new String(chars);
                    if (!seen.contains(transformation) && dictionary.contains(transformation)) {
                        transformations.add(transformation);
                    }
                }
            }
            chars[i] = oldChar;
        }

        return transformations;
    }
}
