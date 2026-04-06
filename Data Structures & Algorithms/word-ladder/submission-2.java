class Solution {
    private Set<String> dictionary;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        int steps = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        dictionary.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        if (newChar != oldChar) {
                            chars[j] = newChar;
                            String transformation = new String(chars);
                            if (dictionary.contains(transformation)) {
                                queue.add(transformation);
                                dictionary.remove(transformation);
                            }
                        }
                    }
                    chars[j] = oldChar;
                }
            }
            steps++;
        }

        return 0;
    }
}
